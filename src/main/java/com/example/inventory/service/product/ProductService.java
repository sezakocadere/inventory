package com.example.inventory.service.product;

import com.example.inventory.model.Product;
import com.example.inventory.request.RequestProduct;

import java.util.List;

public interface ProductService {
    Product createProduct(RequestProduct product);

    void removeProduct(Long id);

    void reductionProduct(int value, Long stockId);

    Product updateProduct(RequestProduct product);

    List<Product> getAllProducts();

}
