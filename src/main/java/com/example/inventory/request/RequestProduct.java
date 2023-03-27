package com.example.inventory.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class RequestProduct {
    private String name;
    private BigDecimal price;
    private Long categoryId;
    private Set<RequestStock> stocks;
    private int criticalThreshold;
}
