package com.greenacademy.service.impl;

import com.greenacademy.model.Product;
import com.greenacademy.service.GenericService;

import java.util.List;

public class ProductServiceImpl implements GenericService<Product, Integer> {
    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product findId(Integer id) {
        return null;
    }

    @Override
    public boolean add(Product item) {
        return false;
    }
}
