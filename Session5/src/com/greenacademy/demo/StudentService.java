package com.greenacademy.demo;

public interface StudentService {
    double RATE = 1.3;

    void addStudent(Student student);

    public default void test() {
        System.out.println("This is a test");
    }
}
