package com.example.inventory.model.category;

import com.example.inventory.dto.CategoryDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    public CategoryDTO toDTO() {
        return new ModelMapper().map(this, CategoryDTO.class);
    }
}
