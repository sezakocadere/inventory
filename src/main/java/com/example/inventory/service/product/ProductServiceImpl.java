package com.example.inventory.service.product;

import com.example.inventory.model.*;
import com.example.inventory.repository.CategoryRepository;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.repository.StockRepository;
import com.example.inventory.repository.WarehouseRepository;
import com.example.inventory.request.RequestProduct;
import com.example.inventory.request.RequestStock;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Log4j2

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final WarehouseRepository warehouseRepository;
    private final StockRepository stockRepository;

    private static void checkCriticalThreshold(int stockQuantity, int criticalThreshold) {
        if (stockQuantity < criticalThreshold) {
            log.warn("quantity of product in stock is below the critical threshold.");
        }
    }

    @Transactional
    @Override
    public Product createProduct(RequestProduct productDTO) {
        Product product = new Product();
        Category category = getCategory(productDTO.getCategoryId());
        product.setName(productDTO.getName());
        product.setCategory(category);
        product.setPrice(productDTO.getPrice());
        product.setCriticalThreshold(productDTO.getCriticalThreshold());
        product.setStatus(Status.ACTIVE);
        productRepository.save(product);
        return product;
    }

    private Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Does not have id: " + id + " category"));
    }

    private Warehouse getWarehouse(Long id) {
        return warehouseRepository.findByIdAndStatus(id, Status.ACTIVE).orElseThrow(() -> new EntityNotFoundException("Does not have id: " + id + " warehouse"));
    }

    private Product getProduct(Long id) {
        return productRepository.findByIdAndStatus(id, Status.ACTIVE).orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

    private Stock getStock(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Does not have id: " + id + " stock"));
    }

    @Transactional
    @Override
    public void removeProduct(Long id) {
        Product product = getProduct(id);
        product.setStatus(Status.PASSIVE);
        productRepository.save(product);
    }

    @Transactional
    @Override
    public void reductionProduct(int value, Long stockId) {
        Stock stock = getStock(stockId);
        int newStock = stock.getQuantity() - value; //eksi değer olursa?
        int criticalThreshold = stock.getProduct().getCriticalThreshold();
        checkCriticalThreshold(newStock, criticalThreshold);
        stock.setQuantity(newStock);
        stockRepository.save(stock);
    }

    @Transactional
    @Override
    public Product updateProduct(RequestProduct productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        Category category = getCategory(productDTO.getCategoryId());
        product.setCategory(category);
        Set<RequestStock> stocks = productDTO.getStocks();
        int criticalThreshold = productDTO.getCriticalThreshold();
        stocks.stream().forEach(stock -> checkCriticalThreshold(stock.getQuantity(), criticalThreshold));
        product.setCriticalThreshold(criticalThreshold);
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
