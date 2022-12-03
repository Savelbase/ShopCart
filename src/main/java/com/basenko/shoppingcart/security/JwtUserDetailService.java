package com.basenko.shoppingcart.security;

import com.basenko.shoppingcart.model.User;
 import com.basenko.shoppingcart.security.jwt.JwtUserFactory;
import com.basenko.shoppingcart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService {

    private final UserService userService ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByLogin(username);
        return JwtUserFactory.create(user);
    }
}
