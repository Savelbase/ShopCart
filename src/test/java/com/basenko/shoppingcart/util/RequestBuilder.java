package com.basenko.shoppingcart.util;

import com.basenko.shoppingcart.dto.request.OrderDto;
import com.basenko.shoppingcart.dto.request.UserDto;
import com.basenko.shoppingcart.model.User;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {
    private static final String test = "test";
    private static final String itemId = "6cd2cd0b-b206-4d3e-9a2a-ee24e687d3e7";
    private static final String testMobilePhone = "+380999999999";
    private static final String testEmail = "test@gmail.com";
    private static final String testLogin = "testLogin";

    public static UserDto createUserDto() {
        UserDto userDto = new UserDto();
        userDto.setEmail(testEmail);
        userDto.setLogin(testLogin);
        userDto.setPassword(test);
        userDto.setFirstName(test);
        userDto.setLastName(test);
        userDto.setPhoneNumber(testMobilePhone);
        return userDto;
    }

    public static OrderDto createOrderDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setItems(new HashMap<>(Map.of(itemId,1)));
        return orderDto;
    }
}
