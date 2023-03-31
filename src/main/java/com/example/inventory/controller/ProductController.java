package com.example.inventory.controller;

import com.example.inventory.dto.ProductDTO;
import com.example.inventory.dto.ProductFilterRequest;
import com.example.inventory.dto.StockDTO;
import com.example.inventory.model.product.Product;
import com.example.inventory.model.warehouse.Warehouse;
import com.example.inventory.request.ProductRequest;
import com.example.inventory.service.product.ProductService;
import com.example.inventory.service.stock.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;
    private final StockService stockService;

    @GetMapping
    public List<ProductDTO> listProducts() {
        return productService.getAllProducts().stream().map(Product::toDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/filter")
    public List<ProductDTO> filterProducts(@RequestBody ProductFilterRequest productFilterRequest) {
        return productService.getAllProducts(productFilterRequest).stream().map(Product::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductRequest requestDTO) {
        return productService.createProduct(requestDTO).toDTO();
    }

    @DeleteMapping(value = "/{productId}")
    public ProductDTO removeProduct(@RequestBody Long productId) {
        return productService.removeProduct(productId).toDTO();
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody ProductRequest requestProduct) {
        return productService.updateProduct(requestProduct).toDTO();
    }

    @PutMapping(value = "/{value}/{stockId}")
    public StockDTO reductionProduct(@PathVariable int value, @PathVariable Long stockId) {
        return productService.reductionProduct(value, stockId).toDTO();
    }

    @GetMapping(value = "/{productId}")
    public List<Warehouse> listWarehousesByProductId(Long productId) {
        return stockService.getWarehousesByProductId(productId);
    }
}
