package com.greenacademy.demo;

import java.util.Scanner;

public class StudentServiceImpl implements StudentService, BaseEntity {
    @Override
    public void input(Scanner sc) {
        System.out.println("com.greenacademy.demo.StudentServiceImpl::input");
    }

    @Override
    public void output() {
        System.out.println("com.greenacademy.demo.StudentServiceImpl::output");
    }

    @Override
    public void addStudent(Student student) {

    }
}
