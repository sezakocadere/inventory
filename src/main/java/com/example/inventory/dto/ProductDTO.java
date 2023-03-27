package com.example.inventory.dto;

import com.example.inventory.request.RequestStock;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class ProductDTO {
    private String name;
    private BigDecimal price;
    private Long categoryId;
    private Set<RequestStock> stocks;
    private int criticalThreshold;
}
