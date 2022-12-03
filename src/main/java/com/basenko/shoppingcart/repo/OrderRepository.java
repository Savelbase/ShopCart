package com.basenko.shoppingcart.repo;

import com.basenko.shoppingcart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepository extends JpaRepository<Order , String> {
    @Modifying
    @Query(value = "delete from orders o where o.expiry_date_time < now() and o.is_closed = false" , nativeQuery = true)
    void checkExpiredOrders();
}
