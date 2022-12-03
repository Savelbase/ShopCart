package com.basenko.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderNotFoundException extends ResponseStatusException {
    public OrderNotFoundException(String orderId){
        super(HttpStatus.NOT_FOUND , String.format("Order by id = %s , not found" , orderId));
    }
}
