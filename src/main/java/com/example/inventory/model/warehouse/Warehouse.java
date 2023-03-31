package com.example.inventory.model.warehouse;

import com.example.inventory.dto.WarehouseDTO;
import com.example.inventory.enums.Status;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Data
public class Warehouse {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String region;
    private String city;
    @Enumerated(EnumType.STRING)
    private Status status;

    public WarehouseDTO toDTO() {
        return new ModelMapper().map(this, WarehouseDTO.class);
    }
}
