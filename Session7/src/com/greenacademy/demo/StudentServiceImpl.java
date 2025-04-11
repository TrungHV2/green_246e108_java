package com.greenacademy.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    List<Student> students = new ArrayList<Student>();

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equals(name)) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public List<Student> findByAge(int from, int to) {
        List<Student> result = new ArrayList<>();
        for (Student x : students) {
            if (x.getAge() >= from && x.getAge() <= to) {
                result.add(x);
            }
        }
        return result;
    }

    @Override
    public List<Student> where(PredicateStudent predicate) {
        List<Student> result = new ArrayList<>();
        for (Student st : students) {
            if (predicate.test(st)) {
                result.add(st);
            }
        }
        return result;
    }
}
