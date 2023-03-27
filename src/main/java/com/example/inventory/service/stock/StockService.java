package com.example.inventory.service.stock;

import com.example.inventory.model.Stock;
import com.example.inventory.model.Warehouse;
import com.example.inventory.request.RequestStock;

public interface StockService {
    Warehouse getWarehousesByProductId(Long productId);

    Stock createStock(RequestStock requestStock);
}
