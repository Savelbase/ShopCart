package com.basenko.shoppingcart.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ItemDto {
    @NotNull
    private String name;
    @NotNull
    private String description ;
    @NotNull
    private Integer costs ;
}
