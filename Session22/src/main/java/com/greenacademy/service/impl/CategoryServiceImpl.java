package com.greenacademy.service.impl;

import com.greenacademy.entity.CategoryEntity;
import com.greenacademy.model.CategoryRequest;
import com.greenacademy.model.CategoryResponse;
import com.greenacademy.repository.CategoryRepository;
import com.greenacademy.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CategoryResponse> findAll() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = categories.stream()
                .map(category -> modelMapper.map(category, CategoryResponse.class))
                .collect(Collectors.toList());
        return categoryResponses;
    }

    @Override
    public List<CategoryResponse> findByName(String name) {
        List<CategoryEntity> categories = categoryRepository.findByNameContaining(name);
        List<CategoryResponse> categoryResponses = categories.stream()
                .map(category -> modelMapper.map(category, CategoryResponse.class))
                .collect(Collectors.toList());
        return categoryResponses;
    }

    @Override
    public CategoryResponse findById(Integer id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        CategoryResponse response = category != null ? modelMapper.map(category, CategoryResponse.class) : null;
        return response;
    }

    @Override
    public CategoryResponse save(CategoryRequest category) {
        CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
        categoryEntity = categoryRepository.save(categoryEntity);
        return modelMapper.map(categoryEntity, CategoryResponse.class);
    }

    @Override
    public boolean delete(Integer id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            categoryRepository.delete(category);
            return true;
        }
        return false;
    }
}
