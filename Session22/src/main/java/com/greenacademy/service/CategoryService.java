package com.greenacademy.service;

import com.greenacademy.model.CategoryRequest;
import com.greenacademy.model.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findAll();
    List<CategoryResponse> findByName(String name);
    CategoryResponse findById(Integer id);
    CategoryResponse save(CategoryRequest category);
    boolean delete(Integer id);
}
