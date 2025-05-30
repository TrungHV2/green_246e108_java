package com.greenacademy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ErrorConfigEntity {
    @Id
    @Column(name = "errorCode", nullable = false, length = 50)
    private String errorCode;

    @Column(name = "message", nullable = false, length = 512)
    private String message;

}