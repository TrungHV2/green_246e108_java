package com.greenacademy.demo;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Person person = new Person();
        person.hello();
        person.hello("Trung");
        System.out.println(person.hello(30));
        Student student = new Student();
        student.hello();
        Employee employee = new Employee();
        employee.hello();

        Person person2 = new Student();

        Person person3 = new Employee();

        hello(person2);
        hello(person3);
        hello(student);


        Staff staff = new Staff() {
            @Override
            public double calculateSalary() {
                return getSalary() * 1.5;
            }
        };


        StudentService studentService = new StudentServiceImpl();
        studentService.test();
        BaseEntity baseEntity = (BaseEntity) studentService;
        baseEntity.input(new Scanner(System.in));
    }

    public static void hello(Person person) {
        if (person instanceof Student) {
            System.out.println("===com.greenacademy.demo.Student===");
        }
        if (person instanceof Employee) {
            System.out.println("===com.greenacademy.demo.Employee===");
        }

        person.hello();
    }
}
