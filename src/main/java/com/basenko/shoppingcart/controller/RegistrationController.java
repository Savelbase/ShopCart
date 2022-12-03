package com.basenko.shoppingcart.controller;

import com.basenko.shoppingcart.dto.request.UserDto;
import com.basenko.shoppingcart.model.User;
import com.basenko.shoppingcart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private final UserService userService ;

    @PostMapping
    void signUp (@RequestBody @Valid UserDto userDto){
        userService.createUser(userDto);
    }

}
