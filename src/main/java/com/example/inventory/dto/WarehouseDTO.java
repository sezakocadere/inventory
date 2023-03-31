package com.example.inventory.dto;

import com.example.inventory.enums.Status;
import lombok.Data;

@Data
public class WarehouseDTO {
    private Long id;
    private String name;
    private String address;
    private String region;
    private String city;
    private Status status;
}
