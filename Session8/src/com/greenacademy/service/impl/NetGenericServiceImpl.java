package com.greenacademy.service.impl;

import com.greenacademy.model.NetEntity;
import com.greenacademy.service.NetGenericService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NetGenericServiceImpl <T extends NetEntity> implements NetGenericService <T> {
    private List<T> data = new ArrayList<>();

    @Override
    public List<T> findAll() {
        return data;
    }

    @Override
    public List<T> where(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : data) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public T findById(Object id) {
        for (T item : data) {
            if (id.equals(item.getKey())) {
                return item;
            }
        }
        return null;
    }

    @Override
    public T findSingle(Predicate<T> predicate) {
        for (T item : data) {
            if (predicate.test(item)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void add(T t) {
        data.add(t);
    }

    @Override
    public void update(T t) {
        T old = findById(t.getKey());
        if (old != null) {
            old.update(t);
        }
    }

    @Override
    public void delete(Object id) {
        T old = findById(id);
        if (old != null) {
            data.remove(old);
        }
    }
}
