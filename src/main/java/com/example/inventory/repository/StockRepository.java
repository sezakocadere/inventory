package com.example.inventory.repository;

import com.example.inventory.enums.Status;
import com.example.inventory.model.stock.Stock;
import com.example.inventory.model.warehouse.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByIdAndStatus(Long id, Status status);

    List<Warehouse> findWarehouseByProductId(Long id);
}
