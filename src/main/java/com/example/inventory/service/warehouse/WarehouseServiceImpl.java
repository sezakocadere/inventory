package com.example.inventory.service.warehouse;

import com.example.inventory.model.Warehouse;
import com.example.inventory.request.RequestWarehouse;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Override
    public Warehouse createWarehouse(RequestWarehouse requestWarehouse) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(requestWarehouse.getName());
        warehouse.setCity(requestWarehouse.getCity());
        warehouse.setRegion(requestWarehouse.getRegion());
        warehouse.setAddress(requestWarehouse.getAddress());
        return warehouse;
    }
}
