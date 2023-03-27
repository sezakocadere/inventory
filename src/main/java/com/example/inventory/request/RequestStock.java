package com.example.inventory.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class RequestStock {
    @NotNull
    private Long productId;
    @NotNull
    private Long warehouseId;
    @NotNull
    private Integer quantity;
}
