package com.example.inventory.dto;

import lombok.Data;

@Data
public class ProductFilterRequest {
    private Long categoryId;
    private Long warehouseId;
    private String region;
    private String city;
}
