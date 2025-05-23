package com.greenacademy.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private Integer id;

    @Column(name = "customerId", nullable = false)
    private Integer customerId;

    @Column(name = "created")
    private Instant created;

    @Column(name = "status")
    private Byte status;

}