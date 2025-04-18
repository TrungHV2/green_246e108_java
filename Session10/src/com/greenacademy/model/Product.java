package com.greenacademy.model;

import com.greenacademy.exception.GreenException;

import java.io.Serial;
import java.io.Serializable;

public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private Provider provider;

    public Product() {
    }

    public Product(String productId, String productName, double price, int quantity, Provider provider) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) throws GreenException {
        if (productId == null || productId.trim().length() == 0) {
            throw new GreenException("Mã sản phẩm không được bỏ trống!");
        }
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
