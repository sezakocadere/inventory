package com.example.inventory.service.warehouse;

import com.example.inventory.model.Warehouse;
import com.example.inventory.repository.WarehouseRepository;
import com.example.inventory.request.WarehouseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;
    @Override
    public Warehouse createWarehouse(WarehouseRequest requestWarehouse) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(requestWarehouse.getName());
        warehouse.setCity(requestWarehouse.getCity());
        warehouse.setRegion(requestWarehouse.getRegion());
        warehouse.setAddress(requestWarehouse.getAddress());
        warehouseRepository.save(warehouse);
        return warehouse;
    }
}
