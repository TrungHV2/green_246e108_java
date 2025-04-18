package com.greenacademy.service;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;

public interface GenericService<T extends Serializable> {
    List<T> findAll();
    List<T> where(Predicate<T> predicate);
    T findId(Object id);
    T findSingle(Predicate<T> predicate);
    boolean save(T item);
    boolean edit(T item);
    boolean delete(Object id);
}
