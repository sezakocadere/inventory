package com.example.inventory.service.warehouse;

import com.example.inventory.model.Warehouse;
import com.example.inventory.request.RequestWarehouse;

public interface WarehouseService {
    Warehouse createWarehouse(RequestWarehouse requestWarehouse);
}
