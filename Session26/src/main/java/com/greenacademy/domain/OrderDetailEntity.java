package com.greenacademy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OrderDetails")
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailId id;

    @MapsId("orderId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderId", nullable = false)
    private OrderEntity order;

    @MapsId("bookId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bookId", nullable = false)
    private BookEntity book;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Float price;

}