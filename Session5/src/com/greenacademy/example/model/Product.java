package com.greenacademy.example.model;

import com.greenacademy.example.service.CategoryService;
import com.greenacademy.example.service.impl.CategoryServiceImpl;

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
        System.out.print("Id: ");
        id = scanner.nextLine();
        do {
            System.out.print("Mã danh mục: ");
            int categoryId = Integer.parseInt(scanner.nextLine());
            CategoryService _catService = new CategoryServiceImpl();
            Category _category = _catService.findById(categoryId);
            if (_category != null) {
                this.category = _category;
                break;
            }
            System.out.println("Mã danh mục không tồn tại! Vui lòng nhập lại!");
        } while (true);
    }

    @Override
    public void output() {

    }
}
