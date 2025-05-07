package com.greenacademy.model.entity;

import java.util.Date;

public class Product {
    private String id;
    private String name;
    private double price;
    private boolean status;
    private Date created;

    public Product() {
    }

    public Product(String id, String name, double price, boolean status, Date created) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.created = created;
    }

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
