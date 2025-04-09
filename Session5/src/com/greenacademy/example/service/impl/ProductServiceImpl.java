package com.greenacademy.example.service.impl;

import com.greenacademy.example.model.Product;
import com.greenacademy.example.service.ProductService;

import java.util.Arrays;

public class ProductServiceImpl implements ProductService {
    private Product[] products;
    private int index = 0;

    public ProductServiceImpl() {
        products = new Product[10];
    }

    @Override
    public Product[] findAll() {
        return Arrays.copyOf(products, index);
    }

    @Override
    public Product findId(String id) {
        for (int i = 0; i < index; i++) {
            if (products[i].getId().equals(id)) {
                return products[i];
            }
        }
        return null;
    }

    @Override
    public Product add(Product product) {
        if (index >= products.length) {
            products = Arrays.copyOf(products, products.length + 10);
        }
        products[index++] = product;
        return product;
    }

    @Override
    public Product update(Product product) {
        Product oldProduct = findId(product.getId());
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setCategory(product.getCategory());
        return oldProduct;
    }

    @Override
    public boolean delete(int id) {
        int delIndex = -1;
        for (int i = 0; i < index; i++) {
            if (products[i].getId().equals(id)) {
                delIndex = i;
                break;
            }
        }
        if (delIndex != -1) {
            index--;
            System.arraycopy(products, index + 1, products, index, index - delIndex);
            products[index] = null;
            return true;
        }
        return false;
    }
}
