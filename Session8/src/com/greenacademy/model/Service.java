package com.greenacademy.model;

public class Service implements NetEntity {
    @Override
    public void update(NetEntity other) {
        Service otherService = (Service) other;
        this.setServiceName(otherService.getServiceName());
        this.setPrice(otherService.getPrice());
    }

    @Override
    public Object getKey() {
        return this.serviceId;
    }

    private int serviceId;
    private String serviceName;
    private double price;

    public Service() {
    }

    public Service(int serviceId, String serviceName, double price) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
