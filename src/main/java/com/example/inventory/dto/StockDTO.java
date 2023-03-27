package com.example.inventory.dto;

import lombok.Data;

@Data
public class StockDTO {
    private Long id;
    private ProductDTO product;
    private WarehouseDTO warehouse;
    private int quantity;


}
