package com.greenacademy.example.model;

import java.util.Scanner;

public class Product implements BaseEntity {
    private String id;
    private String name;
    private double price;
    private Category category;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public void input(Scanner scanner) {

    }

    @Override
    public void output() {

    }
}
