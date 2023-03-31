package com.example.inventory.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WarehouseRequest {
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String region;
    @NotNull
    private String city;
}
