package com.example.inventory.service.category;

import com.example.inventory.model.Category;
import com.example.inventory.request.CategoryRequest;

public interface CategoryService {
    Category createCategory(CategoryRequest categoryRequest);
}
