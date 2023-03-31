package com.example.inventory.model.stock;

import com.example.inventory.dto.StockDTO;
import com.example.inventory.enums.Status;
import com.example.inventory.model.warehouse.Warehouse;
import com.example.inventory.model.product.Product;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Stock {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(optional = false)
    private Product product;
    @ManyToOne(optional = false)
    private Warehouse warehouse;
    @NotNull
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private Status status;

    public StockDTO toDTO() {
        return new ModelMapper().map(this, StockDTO.class);
    }

}
