package com.example.inventory.controller;

import com.example.inventory.dto.WarehouseDTO;
import com.example.inventory.request.WarehouseRequest;
import com.example.inventory.service.warehouse.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @PostMapping
    public WarehouseDTO addWarehouse(@RequestBody WarehouseRequest requestDTO) {
        return warehouseService.createWarehouse(requestDTO).toDTO();
    }
}
