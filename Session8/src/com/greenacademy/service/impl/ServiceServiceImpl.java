package com.greenacademy.service.impl;

import com.greenacademy.model.Service;
import com.greenacademy.service.NetGenericService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ServiceServiceImpl implements NetGenericService<Service> {
    private static final List<Service> services = new ArrayList<>();

    @Override
    public List<Service> findAll() {
        return services;
    }

    @Override
    public List<Service> where(Predicate<Service> predicate) {
        List<Service> result = new ArrayList<>();
        for (Service service : services) {
            if (predicate.test(service)) {
                result.add(service);
            }
        }
        return result;
    }

    @Override
    public Service findById(Object id) {
        for (Service service : services) {
            if (id.equals(service.getKey())) {
                return service;
            }
        }
        return null;
    }

    @Override
    public Service findSingle(Predicate<Service> predicate) {
        for (Service service : services) {
            if (predicate.test(service)) {
                return service;
            }
        }
        return null;
    }

    @Override
    public void add(Service service) {
        services.add(service);
    }

    @Override
    public void update(Service service) {
        Service old = findById(service.getKey());
        if (old != null) {
            old.update(service);
        }
    }

    @Override
    public void delete(Object id) {
        Service service = findById(id);
        if (service != null) {
            services.remove(service);
        }
    }
}
