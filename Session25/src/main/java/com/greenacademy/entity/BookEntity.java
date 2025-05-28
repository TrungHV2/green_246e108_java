package com.greenacademy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

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
    private com.greenacademy.entity.CategoryEntity category;

    @ColumnDefault("(0)")
    @Column(name = "price")
    private Float price;

    @OneToMany(mappedBy = "book")
    private Set<com.greenacademy.entity.OrderDetailEntity> orderDetails = new LinkedHashSet<>();

}