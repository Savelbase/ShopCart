package com.basenko.shoppingcart.controller;

import com.basenko.shoppingcart.dto.request.ItemDto;
import com.basenko.shoppingcart.model.Item;
import com.basenko.shoppingcart.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/goods")
public class GoodsController {
    private final ItemService itemService;

    @GetMapping
    List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    Item getItemById(@PathVariable String id) {
        return itemService.getById(id);
    }

    @PreAuthorize("hasAuthority(T(com.basenko.shoppingcart.model.Role).MANAGER)")
    @PostMapping
    void addItem(@RequestBody ItemDto item) {
        itemService.saveItem(item);
    }


}
