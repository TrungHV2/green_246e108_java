package com.greenacademy.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Computer implements NetEntity {
    @Override
    public void update(NetEntity other) {
        Computer otherComputer = (Computer) other;
        this.setPrice(otherComputer.getPrice());
        this.setStartDate(otherComputer.getStartDate());
        this.setActive(otherComputer.isActive());
        this.setServices(otherComputer.getServices());
    }

    @Override
    public Object getKey() {
        return this.id;
    }

    private String id;
    private double price;
    private Date startDate;
    private boolean active;
    private List<Service> services = new ArrayList<>();

    public Computer() {
    }

    public Computer(String id, double price) {
        this.id = id;
        this.price = price;
        this.active = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "active=" + active +
                ", startDate=" + startDate +
                ", price=" + price +
                ", id='" + id + '\'' +
                '}';
    }
}
