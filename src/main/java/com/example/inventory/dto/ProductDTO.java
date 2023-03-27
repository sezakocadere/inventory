package com.example.inventory.dto;

import com.example.inventory.request.StockRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private Long categoryId;
    private Set<StockRequest> stocks;
    private int criticalThreshold;
}
