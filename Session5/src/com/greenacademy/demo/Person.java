package com.greenacademy.demo;

public class Person {
    private String firstName;
    private String lastName;
    protected int age;

    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void hello() {
        System.out.println("com.greenacademy.demo.Person Hello");
    }

    public void hello(String name) {
        System.out.println("com.greenacademy.demo.Person Hello " + name);
    }
    public String hello(int age) {
        return "com.greenacademy.demo.Person Hello. Age = " + age;
    }
}
