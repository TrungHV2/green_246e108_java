package com.greenacademy.service;

import com.greenacademy.model.BaseEntity;

import java.util.List;

public interface GenericService<T extends BaseEntity, K> {
    List<T> findAll();
    T findId(K id);
    boolean add(T item);
}
