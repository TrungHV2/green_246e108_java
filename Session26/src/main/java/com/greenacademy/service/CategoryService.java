package com.greenacademy.service;


import com.greenacademy.model.request.CategoryRequest;
import com.greenacademy.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findAll();
    List<CategoryResponse> findByName(String name);
    CategoryResponse findById(Integer id);
    CategoryResponse save(CategoryRequest category);
    boolean delete(Integer id);
}
