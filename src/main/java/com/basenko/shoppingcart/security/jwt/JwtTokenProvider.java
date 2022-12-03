package com.basenko.shoppingcart.security.jwt;

import com.basenko.shoppingcart.exception.JwtAuthenticationException;
import com.basenko.shoppingcart.model.Role;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${authentication.token.expirationSec}")
    private long tokenExpiration;
    @Value("${authentication.token.key}")
    private String secret ;
    @Value("${authentication.token.issuer}")
    private String issuer ;
    private final UserDetailsService userDetailsService;

    @PostConstruct
    protected void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(String username , Role role){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role" , role.name());
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime expirationTime = now.plusSeconds(tokenExpiration);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(issuer)
                .setIssuedAt(Date.from(now.toInstant()))
                .setExpiration(Date.from(expirationTime.toInstant()))
                .signWith(SignatureAlgorithm.HS256 , secret)
                .compact();
    }

    public Authentication getAuthentication(String token){
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails , "" , userDetails.getAuthorities());
    }

    public String getUsername(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken (HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken!=null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7 , bearerToken.length());
        }
        return null ;
    }

    public boolean validateToken(String token){
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        }catch (JwtException | IllegalArgumentException e){
            throw new JwtAuthenticationException("JWT token is expired or invalid");
        }
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
