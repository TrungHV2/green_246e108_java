package com.greenacademy.model;

import lombok.Data;

@Data
public class BookResponse {
    private String bookId;
    private String bookName;
    private String author;
    private String categoryName;
    private Float price;
}

