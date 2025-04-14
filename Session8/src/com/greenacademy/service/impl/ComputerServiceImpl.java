package com.greenacademy.service.impl;

import com.greenacademy.model.Computer;
import com.greenacademy.service.NetGenericService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComputerServiceImpl implements NetGenericService<Computer> {
    private static final List<Computer> computers = new ArrayList<>();

    @Override
    public List<Computer> findAll() {
        return computers;
    }

    @Override
    public List<Computer> where(Predicate<Computer> predicate) {
        List<Computer> result = new ArrayList<>();
        for (Computer computer : computers) {
            if (predicate.test(computer)) {
                result.add(computer);
            }
        }
        return result;
    }

    @Override
    public Computer findById(Object id) {
        for (Computer computer : computers) {
            if (id.equals(computer.getKey())) {
                return computer;
            }
        }
        return null;
    }

    @Override
    public Computer findSingle(Predicate<Computer> predicate) {
        for (Computer computer : computers) {
            if (predicate.test(computer)) {
                return computer;
            }
        }
        return null;
    }

    @Override
    public void add(Computer computer) {
        computers.add(computer);
    }

    @Override
    public void update(Computer computer) {
        Computer oldComputer = findById(computer.getKey());
        if (oldComputer != null) {
            oldComputer.update(computer);
        }
    }

    @Override
    public void delete(Object id) {
        Computer computer = findById(id);
        if (computer != null) {
            computers.remove(computer);
        }
    }
}
