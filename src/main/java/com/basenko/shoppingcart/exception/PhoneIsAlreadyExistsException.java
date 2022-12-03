package com.basenko.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PhoneIsAlreadyExistsException extends ResponseStatusException {
    public PhoneIsAlreadyExistsException(String phone) {
        super(HttpStatus.CONFLICT , String.format("Phone %s is already exists" , phone));
    }
}
