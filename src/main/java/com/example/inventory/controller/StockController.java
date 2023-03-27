package com.example.inventory.controller;

import com.example.inventory.dto.StockDTO;
import com.example.inventory.request.StockRequest;
import com.example.inventory.service.stock.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("stock")
public class StockController {
    private final StockService stockService;

    @PostMapping
    public StockDTO addStock(@RequestBody StockRequest requestDTO) {
        return stockService.createStock(requestDTO).toDTO();
    }
}
