package com.example.inventory.service.product;

import com.example.inventory.dto.ProductFilterRequest;
import com.example.inventory.model.product.Product;
import com.example.inventory.model.stock.Stock;
import com.example.inventory.request.ProductRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest product);

    Product removeProduct(Long id);

    Stock reductionProduct(int value, Long stockId);

    Product updateProduct(ProductRequest product);

    List<Product> getAllProducts();

    List<Product> getAllProducts(ProductFilterRequest productFilterRequest);

}
