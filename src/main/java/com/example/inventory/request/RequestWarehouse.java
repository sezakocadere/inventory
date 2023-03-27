package com.example.inventory.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class RequestWarehouse {
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String region;
    @NotNull
    private String city;
}
