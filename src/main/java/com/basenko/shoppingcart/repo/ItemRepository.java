package com.basenko.shoppingcart.repo;

import com.basenko.shoppingcart.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item , String> {
}
