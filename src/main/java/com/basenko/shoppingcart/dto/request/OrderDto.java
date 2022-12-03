package com.basenko.shoppingcart.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;


@Data
public class OrderDto {
    // Map where key is id of the item , and value is count of items
    private Map<String, Integer> items;
}