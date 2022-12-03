package com.basenko.shoppingcart.service;

import com.basenko.shoppingcart.dto.request.OrderDto;
import com.basenko.shoppingcart.exception.OrderNotFoundException;
import com.basenko.shoppingcart.exception.PaymentDeniedException;
import com.basenko.shoppingcart.model.Item;
import com.basenko.shoppingcart.model.Order;
import com.basenko.shoppingcart.model.User;
import com.basenko.shoppingcart.repo.ItemRepository;
import com.basenko.shoppingcart.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Value("${orders.expiration.time}")
    private Integer orderExpirationSec;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final UserService userService ;

    @Transactional
    public void createOrder(OrderDto orderDto, String login) {

        User user = userService.findUserByLogin(login);

        List<Item> itemList = new ArrayList<>();

        ZonedDateTime currentDateTime = ZonedDateTime.now();
        ZonedDateTime expiryDateTime = currentDateTime.plus(orderExpirationSec, ChronoUnit.SECONDS);

        Order order = Order.builder()
                .id(UUID.randomUUID().toString())
                .clientId(user.getId())
                .items(itemList)
                .expiryDateTime(expiryDateTime)
                .isClosed(false)
                .build();

        orderDto.getItems().forEach((key, value) -> {
            if (itemRepository.findById(key).isPresent()) {
                Item item = itemRepository.findById(key).get();
                for (int i = 0; i < value; i++) {
                    itemList.add(item);
                    order.setTotalCost(item.getCosts());
                }
            }
        });

        orderRepository.save(order);
    }


    @Transactional
    public void closeOrder(String id , String login) {
        Order order = orderRepository.findById(id).orElseThrow(() -> {
            throw new OrderNotFoundException(id);
        });
        User user = userService.getUserById(order.getClientId());
        if (!user.getLogin().equals(login)){
            throw new PaymentDeniedException();
        }
        order.setClosed(true);
        orderRepository.save(order);
    }
}
