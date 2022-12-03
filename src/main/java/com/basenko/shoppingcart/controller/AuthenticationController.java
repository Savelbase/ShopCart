package com.basenko.shoppingcart.controller;


import com.basenko.shoppingcart.dto.request.LoginAndPasswordDto;
import com.basenko.shoppingcart.model.User;
import com.basenko.shoppingcart.security.jwt.JwtTokenProvider;
import com.basenko.shoppingcart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<Map<Object, Object>> login(@RequestBody LoginAndPasswordDto loginAndPasswordDto) {
        String login = loginAndPasswordDto.getLogin();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, loginAndPasswordDto.getPassword()));
        User user = userService.findUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with login %s not found", login));
        }
        String token = jwtTokenProvider.createToken(login, user.getRole());
        Map<Object, Object> response = new HashMap<>();
        response.put("userId", user.getId());
        response.put("username", login);
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}


