package com.greenacademy.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "Books")
public class BookEntity {
    @Id
    @Column(name = "bookId", nullable = false, length = 36)
    private String bookId;

    @Column(name = "bookName", nullable = false, length = 250)
    private String bookName;

    @Column(name = "author", nullable = false, length = 250)
    private String author;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    private com.greenacademy.model.entity.CategoryEntity category;

    @ColumnDefault("(0)")
    @Column(name = "price")
    private Float price;

}