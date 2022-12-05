package com.basenko.shoppingcart.controller;

import com.basenko.shoppingcart.dto.request.UserDto;
import com.basenko.shoppingcart.dto.response.SuccessResponse;
import com.basenko.shoppingcart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private final UserService userService ;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SuccessResponse signUp (@RequestBody @Valid UserDto userDto){
        userService.createUser(userDto);
        return new SuccessResponse("User Created");
    }

}
