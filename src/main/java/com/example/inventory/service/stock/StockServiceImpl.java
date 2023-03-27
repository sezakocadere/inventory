package com.example.inventory.service.stock;

import com.example.inventory.model.Product;
import com.example.inventory.model.Stock;
import com.example.inventory.model.Warehouse;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.repository.StockRepository;
import com.example.inventory.repository.WarehouseRepository;
import com.example.inventory.request.RequestStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProductRepository productRepository;

    @Override
    public Warehouse getWarehousesByProductId(Long productId) {
        warehouseRepository.findWarehousesByProductId(productId);
        return null;
    }

    @Override
    public Stock createStock(RequestStock requestStock) {
        Stock stock = new Stock();
        stock.setQuantity(requestStock.getQuantity());
        Warehouse warehouse = warehouseRepository.findById(requestStock.getWarehouseId()).orElseThrow();
        stock.setWarehouse(warehouse);
        Product product = productRepository.findById(requestStock.getProductId()).orElseThrow();
        stock.setProduct(product);
        stockRepository.save(stock);
        return stock;
    }
}
