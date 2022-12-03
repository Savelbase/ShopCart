package com.basenko.shoppingcart.utils;

import com.basenko.shoppingcart.repo.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.concurrent.TimeUnit;


@Component
@Data
@AllArgsConstructor
@EnableScheduling
public class OrderScheduler {

    private final OrderRepository orderRepository ;

    @Transactional
    @Scheduled(fixedDelay = 60 , timeUnit = TimeUnit.SECONDS)
    public void fixedDelaySchedule() {
        orderRepository.checkExpiredOrders();
    }
}
