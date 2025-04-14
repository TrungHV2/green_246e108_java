package com.greenacademy.service;

import java.util.List;
import java.util.function.Predicate;

public interface NetGenericService <T> {
    List<T> findAll();
    List<T> where(Predicate<T> predicate);
    T findById(Object id);
    T findSingle(Predicate<T> predicate);
    void add(T t);
    void update(T t);
    void delete(Object id);
}
