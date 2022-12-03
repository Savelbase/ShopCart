package com.basenko.shoppingcart.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    private String id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String password ;
    private String login ;
    private String phoneNumber ;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role ;
}
