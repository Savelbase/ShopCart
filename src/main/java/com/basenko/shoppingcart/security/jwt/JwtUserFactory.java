package com.basenko.shoppingcart.security.jwt;

import com.basenko.shoppingcart.model.Role;
import com.basenko.shoppingcart.model.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public final class JwtUserFactory {
    public static JwtUser create (User user){
        return JwtUser.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .password(user.getPassword())
                .authorities(roleToGrantedAuthorities(user.getRole()))
                .build();
    }

    private static List<GrantedAuthority> roleToGrantedAuthorities(Role role){
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }
}
