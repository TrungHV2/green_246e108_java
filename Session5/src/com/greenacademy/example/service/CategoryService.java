package com.greenacademy.example.service;

import com.greenacademy.example.model.Category;

public interface CategoryService {
    Category[] findAll();
    Category findById(int id);
    Category add(Category category);
    Category update(Category category);
    Category delete(int id);
}
