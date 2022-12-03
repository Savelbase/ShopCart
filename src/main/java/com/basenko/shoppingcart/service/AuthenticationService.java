package com.basenko.shoppingcart.service;

import com.basenko.shoppingcart.exception.UserNotFoundException;
import com.basenko.shoppingcart.model.User;
import com.basenko.shoppingcart.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;


    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> {
                    throw new UserNotFoundException(login, true);
                });
    }

}
