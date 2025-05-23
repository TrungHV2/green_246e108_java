package com.greenacademy.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class OrderDetailEntityId implements java.io.Serializable {
    private static final long serialVersionUID = -3854441395536465506L;
    @Column(name = "orderId", nullable = false)
    private Integer orderId;

    @Column(name = "bookId", nullable = false, length = 36)
    private String bookId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDetailEntityId entity = (OrderDetailEntityId) o;
        return Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.bookId, entity.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, bookId);
    }

}