package com.basenko.shoppingcart.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {
    @Id
    @NotNull
    private String id;
    @NotNull
    private String clientId;
    private ZonedDateTime expiryDateTime;
    @ManyToMany
    @JoinTable(
            name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    private boolean isClosed = false;
    private int totalCost = 0;

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }
}
