package com.greenacademy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "UserRoles")
public class UserRoleEntity {
    @EmbeddedId
    private UserRoleEntityId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private com.greenacademy.entity.UserEntity user;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

}