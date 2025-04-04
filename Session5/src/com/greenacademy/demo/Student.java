package com.greenacademy.demo;

public class Student extends Person {
    private String className;
    private double mark;

    public Student() {
    }

    public Student(String firstName, String lastName, int age, String className, double mark) {
        super(firstName, lastName, age);
        this.className = className;
        this.mark = mark;
    }

    @Override
    public void hello() {
        System.out.println("com.greenacademy.demo.Student Hello");
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
