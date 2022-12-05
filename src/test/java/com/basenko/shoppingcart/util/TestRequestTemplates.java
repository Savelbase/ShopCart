package com.basenko.shoppingcart.util;

public class TestRequestTemplates {
    public static String loginAndPasswordDto = "{\"login\" : \"test\" , \"password\" : \"test\" }";
    public static String failedLoginAndPasswordDto = "{\"login\" : \"test\" , \"password\" : \"password\" }";
    public static String newItem = "{\"name\" : \"test\" , \"description\" : \"test\" , \"costs\": 123 }";
}
