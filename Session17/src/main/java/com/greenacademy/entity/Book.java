package com.greenacademy.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private int categoryId;
    private double price;

    public static Book build(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.bookId = rs.getString("bookId");
        book.bookName = rs.getString("bookName");
        book.author = rs.getString("author");
        book.categoryId = rs.getInt("categoryId");
        book.price = rs.getDouble("price");
        return book;
    }

    public Book() {
    }

    public Book(String bookId, String bookName, String author, int categoryId, double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.categoryId = categoryId;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
