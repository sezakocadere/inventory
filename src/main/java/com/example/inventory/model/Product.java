package com.example.inventory.model;

import com.example.inventory.dto.ProductDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal price;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Stock> stocks;
    private int criticalThreshold;
    private Status status;

    public ProductDTO toDTO() {
        return new ModelMapper().map(this, ProductDTO.class);
    }
}
