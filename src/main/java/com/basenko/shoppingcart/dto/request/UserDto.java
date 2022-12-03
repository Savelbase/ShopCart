package com.basenko.shoppingcart.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName ;
    private String lastName ;
    @Email
    @NonNull
    private String email ;
    @NonNull
    private String password ;
    @NonNull
    private String login ;
    @NonNull
    @Pattern(regexp = "^\\+380\\d{9}$")
    private String phoneNumber ;
}
