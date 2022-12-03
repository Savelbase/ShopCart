package com.basenko.shoppingcart.controller;

import com.basenko.shoppingcart.dto.request.OrderDto;
import com.basenko.shoppingcart.security.SecurityUtil;
import com.basenko.shoppingcart.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final SecurityUtil securityUtil;

    @PreAuthorize("hasAuthority(T(com.basenko.shoppingcart.model.Role).CLIENT)")
    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto) {
        String login = securityUtil.getCurrentUser();
        orderService.createOrder(orderDto , login);
    }

    @PreAuthorize("hasAuthority(T(com.basenko.shoppingcart.model.Role).CLIENT)")
    @PostMapping("/payment/{id}")
    public void orderPayment(@PathVariable String id) {
        String login = securityUtil.getCurrentUser();
        orderService.closeOrder(id , login);
    }


}
