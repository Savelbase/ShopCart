package com.basenko.shoppingcart.controller;

import com.basenko.shoppingcart.model.User;
import com.basenko.shoppingcart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping
    List<User> getAll(){
        return userService.getAllUsers();
    }
}
