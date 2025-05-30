package com.greenacademy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = 250)
    private String password;

    @ColumnDefault("(1)")
    @Column(name = "status")
    private Byte status;

    @OneToMany(mappedBy = "user")
    private Set<UserRoleEntity> roles = new LinkedHashSet<>();

}