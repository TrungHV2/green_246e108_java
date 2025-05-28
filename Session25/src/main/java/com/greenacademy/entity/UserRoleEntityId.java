package com.greenacademy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UserRoleEntityId implements java.io.Serializable {
    private static final long serialVersionUID = -850475801201839275L;
    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;

    @Column(name = "role_id", nullable = false, length = 100)
    private String roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserRoleEntityId entity = (UserRoleEntityId) o;
        return Objects.equals(this.roleId, entity.roleId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, userId);
    }

}