package com.greenacademy.model;

import com.greenacademy.model.entity.Product;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProductService {
    public List<Product> getAll() {
        return Arrays.asList(
                new Product("SP01", "Tivi", 15490000, true, new Date()),
                new Product("SP02", "Tủ lạnh", 5000, false, new Date()),
                new Product("SP03", "Điều hòa", 5000, true, new Date()),
                new Product("SP04", "Máy giặt", 5000, false, new Date()),
                new Product("SP05", "Nồi cơm", 5000, true, new Date())
        );
    }
}
