package com.example.inventory.request;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StockRequest {
    @NotNull
    private Long productId;
    @NotNull
    private Long warehouseId;
    @NotNull
    private Integer quantity;
}
