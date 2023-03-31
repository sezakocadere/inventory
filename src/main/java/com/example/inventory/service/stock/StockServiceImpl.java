package com.example.inventory.service.stock;

import com.example.inventory.error.NotFoundObjectException;
import com.example.inventory.model.product.Product;
import com.example.inventory.enums.Status;
import com.example.inventory.model.stock.Stock;
import com.example.inventory.model.warehouse.Warehouse;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.repository.StockRepository;
import com.example.inventory.repository.WarehouseRepository;
import com.example.inventory.request.StockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Warehouse> getWarehousesByProductId(Long productId) {
        return stockRepository.findWarehouseByProductId(productId);
    }

    @Override
    public Stock createStock(StockRequest requestStock) {
        Stock stock = new Stock();
        stock.setQuantity(requestStock.getQuantity());
        Warehouse warehouse = warehouseRepository.findById(requestStock.getWarehouseId()).orElseThrow(() -> new NotFoundObjectException("Not Found Warehouse"));
        stock.setWarehouse(warehouse);
        Product product = productRepository.findById(requestStock.getProductId()).orElseThrow(() -> new NotFoundObjectException("Not Found Product"));
        stock.setProduct(product);
        stock.setStatus(Status.ACTIVE);
        stockRepository.save(stock);
        return stock;
    }
}
