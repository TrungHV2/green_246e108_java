package com.greenacademy.example.service.impl;

import com.greenacademy.example.model.Category;
import com.greenacademy.example.service.CategoryService;

import java.util.Arrays;
// Singleton Pattern
public class CategoryServiceImpl implements CategoryService {
    private static Category[] categories = new Category[10];
    private static int index = 0;

    public CategoryServiceImpl() {
    }

    @Override
    public Category[] findAll() {
        return Arrays.copyOf(categories, index);
    }

    @Override
    public Category findById(int id) {
        for (int i = 0; i < index; i++) {
            if (categories[i].getId() == id) {
                return categories[i];
            }
        }
        return null;
    }

    @Override
    public Category add(Category category) {
        if (index >= categories.length) {
            resize();
        }
        categories[index++] = category;
        return category;
    }

    @Override
    public Category update(Category category) {
        Category update = this.findById(category.getId());
        update.setName(category.getName());
        return update;
    }

    @Override
    public Category delete(int id) {
        int findIndex = -1;
        Category delete = null;
        for (int i = 0; i < index; i++) {
            if (categories[i].getId() == id) {
                findIndex = i;
                delete = categories[i];
                break;
            }
        }
        if (findIndex != -1) {
            index--;
            System.arraycopy(categories, findIndex + 1, categories, findIndex, index - findIndex);
            categories[index + 1] = null;
        }
        return delete;
    }

    private void resize() {
        categories = Arrays.copyOf(categories, categories.length + 10);
    }
}
