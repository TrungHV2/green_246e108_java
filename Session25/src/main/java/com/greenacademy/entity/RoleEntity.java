package com.greenacademy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Roles")
public class RoleEntity {
    @Id
    @Column(name = "id", nullable = false, length = 100)
    private String id;

    @Column(name = "role_name", nullable = false, length = 250)
    private String roleName;

}