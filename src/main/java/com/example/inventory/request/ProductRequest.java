package com.example.inventory.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class ProductRequest {
    private String name;
    private BigDecimal price;
    private Long categoryId;
    private Set<StockRequest> stocks;
    private int criticalThreshold;
}
