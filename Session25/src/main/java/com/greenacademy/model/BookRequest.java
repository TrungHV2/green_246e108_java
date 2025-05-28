package com.greenacademy.model;

import lombok.Data;

@Data
public class BookRequest {
    private String bookId;
    private String bookName;
    private String author;
    private String categoryId;
    private Float price;
}
