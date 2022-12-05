package com.basenko.shoppingcart.util;

import com.google.gson.Gson;

public class TestUtils {
    public static  <T> String convertRequestDtoToJson(T requestDto) {
        Gson gson = new Gson();
        return gson.toJson(requestDto);
    }
}
