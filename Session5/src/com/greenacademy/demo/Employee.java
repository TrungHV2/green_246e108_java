package com.greenacademy.demo;

public class Employee extends Person {
    private double salary;
    private String department;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int age, double salary, String department) {
        super(firstName, lastName, age);
        this.salary = salary;
        this.department = department;
    }

    @Override
    public void hello() {
        super.hello();
        System.out.println("com.greenacademy.demo.Employee Hello");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
