package com.example.inventory.controller;

import com.example.inventory.dto.ProductDTO;
import com.example.inventory.model.Product;
import com.example.inventory.request.RequestProduct;
import com.example.inventory.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> listProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody RequestProduct requestDTO) {
        return productService.createProduct(requestDTO).toDTO();
    }

    @DeleteMapping(value = "/{productId}")
    public void removeProduct(@RequestBody Long productId) {
        productService.removeProduct(productId);
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody RequestProduct requestProduct) {
        return productService.updateProduct(requestProduct).toDTO();
    }

    @PutMapping(value = "/{value}/{stockId}")
    public void reductionProduct(@RequestHeader int value, Long stockId) {
        productService.reductionProduct(value, stockId);
    }
}
