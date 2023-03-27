package com.example.inventory.service.stock;

import com.example.inventory.model.Stock;
import com.example.inventory.model.Warehouse;
import com.example.inventory.request.StockRequest;

import java.util.List;

public interface StockService {
    List<Warehouse> getWarehousesByProductId(Long productId);
    Stock createStock(StockRequest requestStock);
}
