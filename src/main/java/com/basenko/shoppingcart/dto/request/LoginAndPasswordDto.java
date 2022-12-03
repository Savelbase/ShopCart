package com.basenko.shoppingcart.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class LoginAndPasswordDto {
    @NotNull
    private String login;

    @NotNull
    private String password;

}
