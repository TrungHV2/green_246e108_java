package com.greenacademy.example.service;

import com.greenacademy.example.model.Product;

public interface ProductService {
    Product[] findAll();
    Product findId(String id);
    Product add(Product product);
    Product update(Product product);
    boolean delete(int id);
}
