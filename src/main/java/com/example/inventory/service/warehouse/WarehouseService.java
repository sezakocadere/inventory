package com.example.inventory.service.warehouse;

import com.example.inventory.model.Warehouse;
import com.example.inventory.request.WarehouseRequest;

public interface WarehouseService {
    Warehouse createWarehouse(WarehouseRequest requestWarehouse);
}
