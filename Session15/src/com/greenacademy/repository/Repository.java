package com.greenacademy.repository;

import java.util.List;

public interface Repository <T, K> {
    List<T> findAll();
    List<T> pagination(int page,int pageSize);
    T findById(K id);
    T save(T t);
    boolean update(T t);
    boolean delete(K id);
}
