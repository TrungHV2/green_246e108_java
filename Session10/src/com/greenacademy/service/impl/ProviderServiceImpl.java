package com.greenacademy.service.impl;

import com.greenacademy.model.Provider;
import com.greenacademy.service.FileService;
import com.greenacademy.service.GenericService;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProviderServiceImpl implements GenericService<Provider> {
    private final List<Provider> providers;
    private final FileService<Provider> fileService;
    private final String PATH = "data/providers.db";

    public ProviderServiceImpl() {
        this.fileService = new FileServiceImpl<>();
        this.providers = fileService.load(PATH);
    }

    @Override
    public List<Provider> findAll() {
        return this.providers;
    }

    @Override
    public List<Provider> where(Predicate<Provider> predicate) {
        return this.providers.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public Provider findId(Object id) {
        return findSingle(p -> p.getProviderId().equals(id));
    }

    @Override
    public Provider findSingle(Predicate<Provider> predicate) {
        return this.providers.stream().filter(predicate).findFirst().orElse(null);
    }

    @Override
    public boolean save(Provider item) {
        try {
            this.providers.add(item);
            fileService.save(PATH, this.providers);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Provider item) {
        try {
            Provider old = findId(item.getProviderId());
            if (old != null) {
                old.setProviderName(item.getProviderName());
                old.setAddress(item.getAddress());
                old.setPhone(item.getPhone());
                fileService.save(PATH, this.providers);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Object id) {
        try {
            Provider old = findId(id);
            if (old != null) {
                this.providers.remove(old);
                fileService.save(PATH, this.providers);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
