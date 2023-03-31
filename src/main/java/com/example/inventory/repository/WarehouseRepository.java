package com.example.inventory.repository;

import com.example.inventory.enums.Status;
import com.example.inventory.model.warehouse.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findByIdAndStatus(Long id, Status status);
}
