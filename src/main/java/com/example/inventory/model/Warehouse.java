package com.example.inventory.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Warehouse {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    private String address;
    private String region;
    private String city;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
}
