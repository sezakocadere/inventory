package com.example.inventory.controller;

import com.example.inventory.dto.CategoryDTO;
import com.example.inventory.request.CategoryRequest;
import com.example.inventory.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryRequest requestDTO) {
        return categoryService.createCategory(requestDTO).toDTO();
    }
}
