package com.basenko.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PaymentDeniedException extends ResponseStatusException {
    public PaymentDeniedException() {
        super(HttpStatus.FORBIDDEN , "Customers can only pay for their own orders");
    }
}
