package com.greenacademy.demo;

public class Employeee extends Staff {


    @Override
    public double calculateSalary() {
        return getSalary() * 1.3;
    }
}
