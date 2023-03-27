package com.example.inventory.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Stock {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(optional = false)
    private Product product;
    @ManyToOne(optional = false)
    private Warehouse warehouse;
    @NotNull
    private Integer quantity;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
}
