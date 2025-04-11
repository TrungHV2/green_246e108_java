package com.greenacademy.demo;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void save(Student student);
    List<Student> findByName(String name);
    List<Student> findByAge(int from, int to);
    List<Student> where(PredicateStudent predicate);
}
