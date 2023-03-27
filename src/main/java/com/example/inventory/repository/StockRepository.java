package com.example.inventory.repository;

import com.example.inventory.model.Status;
import com.example.inventory.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByIdAndStatus(Long id, Status status);

}
