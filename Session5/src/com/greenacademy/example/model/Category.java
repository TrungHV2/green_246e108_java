package com.greenacademy.example.model;

import com.greenacademy.example.service.CategoryService;

import java.util.Scanner;

public class Category implements BaseEntity {
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void input(Scanner scanner) {
        System.out.print("Id = ");
        this.id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name = ");
        this.name = scanner.nextLine();
        System.out.println("==========");
    }

    @Override
    public void output() {
        System.out.println("[id="+this.id+", name="+this.name+"]");
    }
}
