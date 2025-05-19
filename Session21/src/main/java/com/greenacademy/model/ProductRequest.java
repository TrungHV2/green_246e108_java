package com.greenacademy.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class ProductRequest {
    @NotBlank(message = "Mã sản phẩm không được bỏ trống!")
    private String productId;
    @NotBlank(message = "Tên sản phẩm không được bỏ trống!")
    private String productName;
    @NotBlank(message = "Mô tả sản phẩm không được bỏ trống!")
    private String productDescription;
    @Min(value = 1000, message = "Giá sản phẩm tối thiểu là 1000")
    private double price;
    @PastOrPresent(message = "Ngày tạo không được nhập ngày tương lai!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @NotNull(message = "Vui lòng nhập ảnh sản phẩm!")
    private MultipartFile image;

    public ProductRequest() {
    }

    public ProductRequest(String productId, String productName, String productDescription, double price, Date created, MultipartFile image) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.created = created;
        this.image = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
