package com.example.inventory.service.product;

import com.example.inventory.dto.ProductFilterRequest;
import com.example.inventory.model.Product;
import com.example.inventory.request.ProductRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest product);

    void removeProduct(Long id);

    void reductionProduct(int value, Long stockId);

    Product updateProduct(ProductRequest product);

    List<Product> getAllProducts();

    List<Product> getAllProducts(ProductFilterRequest productFilterRequest);

}
