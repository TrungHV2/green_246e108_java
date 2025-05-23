package com.greenacademy.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ErrorConfig")
public class ErrorConfigEntity {
    @Id
    @Column(name = "errorCode")
    private String errorCode;

    @Column(name = "message")
    private String message;
}
