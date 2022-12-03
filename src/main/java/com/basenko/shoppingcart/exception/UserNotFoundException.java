package com.basenko.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException  extends ResponseStatusException {
    public UserNotFoundException(String userId) {
        super(HttpStatus.NOT_FOUND, String.format("User with id = '%s' not found", userId));
    }

    public UserNotFoundException(String login, boolean isLogin) {
        super(HttpStatus.NOT_FOUND, String.format("User with login = '%s' not found", login));
    }
}
