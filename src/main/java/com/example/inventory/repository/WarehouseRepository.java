package com.example.inventory.repository;

import com.example.inventory.model.Status;
import com.example.inventory.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findByIdAndStatus(Long id, Status status);
    List<Warehouse> findWarehousesByProductId(Long id);

}
