package com.example.inventory.service.product;

import com.example.inventory.dto.ProductFilterRequest;
import com.example.inventory.error.NotFoundObjectException;
import com.example.inventory.error.UnexpectedValueException;
import com.example.inventory.model.*;
import com.example.inventory.repository.CategoryRepository;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.repository.StockRepository;
import com.example.inventory.repository.WarehouseRepository;
import com.example.inventory.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            log.warn("Quantity of product in stock is below the critical threshold.");
        }
    }

    @Transactional
    @Override
    public Product createProduct(ProductRequest productDTO) {
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
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundObjectException("Does not have category id: " + id));
    }

    private Warehouse getWarehouse(Long id) {
        return warehouseRepository.findByIdAndStatus(id, Status.ACTIVE).orElseThrow(() -> new NotFoundObjectException("Does not have warehouse id: " + id));
    }

    private Product getProduct(Long id) {
        return productRepository.findByIdAndStatus(id, Status.ACTIVE).orElseThrow(() -> new NotFoundObjectException("Product not found with id: " + id));
    }

    private Stock getStock(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new NotFoundObjectException("Does not have stock id: " + id));
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
        int newStock = stock.getQuantity() - value;
        if (newStock < 0) {
            throw new UnexpectedValueException("can not enter value greater than quantitiy");
        }
        checkCriticalThreshold(newStock, stock.getProduct().getCriticalThreshold());
        stock.setQuantity(newStock);
        stockRepository.save(stock);
    }

    @Transactional
    @Override
    public Product updateProduct(ProductRequest productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(getCategory(productDTO.getCategoryId()));
        int criticalThreshold = productDTO.getCriticalThreshold();
        productDTO.getStocks().stream().forEach(stock -> checkCriticalThreshold(stock.getQuantity(), criticalThreshold));
        product.setCriticalThreshold(criticalThreshold);
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProducts(ProductFilterRequest productFilterRequest) {
        return productRepository.findAll(Specification.where(filterByCategory(productFilterRequest.getCategoryId())).and(filterByWarehouse(productFilterRequest.getWarehouseId())).and(filterByWarehouseRegion(productFilterRequest.getRegion()).and(filterByWarehouseCity(productFilterRequest.getCity()))));
    }

    private Specification<Product> filterByCategory(Long categoryId) {
        return categoryId != null ? (root, cq, cb) -> cb.equal(root.get("category").get("id"), categoryId) : Specification.where(null);
    }

    private Specification<Product> filterByWarehouse(Long warehouseId) {
        return warehouseId != null ? (root, cq, cb) -> cb.equal(root.join("stocks").get("warehouse").get("id"), warehouseId) : Specification.where(null);
    }

    private Specification<Product> filterByWarehouseRegion(String region) {
        return region != null ? (root, cq, cb) -> cb.equal(root.join("stocks").get("warehouse").get("region"), region) : Specification.where(null);
    }

    private Specification<Product> filterByWarehouseCity(String city) {
        return city != null ? (root, cq, cb) -> cb.equal(root.join("stocks").get("warehouse").get("city"), city) : Specification.where(null);
    }
}
