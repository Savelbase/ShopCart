package com.basenko.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LoginIsAlreadyExistsException extends ResponseStatusException {
    public LoginIsAlreadyExistsException(String mail) {
        super(HttpStatus.CONFLICT , String.format("Login %s is already exists" , mail));
    }
}
