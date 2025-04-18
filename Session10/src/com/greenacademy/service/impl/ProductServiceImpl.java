package com.greenacademy.service.impl;

import com.greenacademy.model.Product;
import com.greenacademy.service.FileService;
import com.greenacademy.service.GenericService;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductServiceImpl implements GenericService<Product> {
    private final List<Product> products;
    private final FileService<Product> fileService;
    private final String PATH = "data/products.db";

    public ProductServiceImpl() {
        this.fileService = new FileServiceImpl<>();
        this.products = fileService.load(PATH);
    }

    @Override
    public List<Product> findAll() {
        return this.products;
    }

    @Override
    public List<Product> where(Predicate<Product> predicate) {
        return this.products.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public Product findId(Object id) {
        return findSingle(p -> p.getProductId().equals(id));
    }

    @Override
    public Product findSingle(Predicate<Product> predicate) {
        return this.products.stream()
                .filter(predicate).findFirst().orElse(null);
    }

    @Override
    public boolean save(Product item) {
        try {
            this.products.add(item);
            fileService.save(PATH, this.products);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean edit(Product item) {
        try {
            Product old = findId(item.getProductId());
            if (old != null) {
                old.setProductName(item.getProductName());
                old.setPrice(item.getPrice());
                old.setQuantity(item.getQuantity());
                old.setProvider(item.getProvider());
                fileService.save(PATH, this.products);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean delete(Object id) {
        try {
            Product old = findId(id);
            if (old != null) {
                this.products.remove(old);
                fileService.save(PATH, this.products);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}
