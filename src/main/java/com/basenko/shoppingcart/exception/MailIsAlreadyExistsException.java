package com.basenko.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MailIsAlreadyExistsException extends ResponseStatusException {
    public MailIsAlreadyExistsException(String mail) {
        super(HttpStatus.CONFLICT , String.format("Mail %s is already exists" , mail));
    }
}
