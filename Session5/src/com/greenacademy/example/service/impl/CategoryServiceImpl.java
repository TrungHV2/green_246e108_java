package com.greenacademy.example.service.impl;

import com.greenacademy.example.model.Category;
import com.greenacademy.example.service.CategoryService;

import java.util.Arrays;

public class CategoryServiceImpl implements CategoryService {
    private Category[] categories;
    private int index = 0;

    public CategoryServiceImpl() {
        this.categories = new Category[10];
    }

    @Override
    public Category[] findAll() {
        return Arrays.copyOf(this.categories, this.index);
    }

    @Override
    public Category findById(int id) {
        for (int i = 0; i < this.index; i++) {
            if (categories[i].getId() == id) {
                return categories[i];
            }
        }
        return null;
    }

    @Override
    public Category add(Category category) {
        if (this.index >= this.categories.length) {
            resize();
        }
        this.categories[this.index++] = category;
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
        for (int i = 0; i < this.index; i++) {
            if (categories[i].getId() == id) {
                findIndex = i;
                delete = categories[i];
                break;
            }
        }
        if (findIndex != -1) {
            this.index--;
            System.arraycopy(this.categories, findIndex + 1, this.categories, findIndex, this.index - findIndex);
            this.categories[this.index + 1] = null;
        }
        return delete;
    }

    private void resize() {
        this.categories = Arrays.copyOf(this.categories, this.categories.length + 10);
    }
}
