package com.basenko.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Goods")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Item {
    @Id
    private String id;
    private String name;
    private String description ;
    private Integer costs ;
    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    @ToString.Exclude
    Set<Order> orders;
}
