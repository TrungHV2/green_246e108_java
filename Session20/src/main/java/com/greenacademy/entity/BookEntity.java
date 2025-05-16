package com.greenacademy.entity;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class BookEntity {
    @Id
    @Column(name = "bookId")
    private String bookId;
    @Column(name = "bookName")
    private String bookName;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private CategoryEntity category;

    public BookEntity() {
    }

    public BookEntity(String bookId, String bookName, String author, double price, CategoryEntity category) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
