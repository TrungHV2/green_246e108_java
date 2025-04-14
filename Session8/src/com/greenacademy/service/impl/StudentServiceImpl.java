package com.greenacademy.service.impl;

import com.greenacademy.model.Student;
import com.greenacademy.service.GenericService;

import java.util.List;

public class StudentServiceImpl implements GenericService<Student, String> {
    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Student findId(String id) {
        return null;
    }

    @Override
    public boolean add(Student item) {
        return false;
    }
}
