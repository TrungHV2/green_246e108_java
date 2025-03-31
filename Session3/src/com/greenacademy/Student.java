package com.greenacademy;

import java.util.Scanner;

public class Student {
    // Fields các biến mang thông tin đặc trưng của đối tượng
    private String id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String address;
    // Alt + Insert để generate code (constructor,getter, setter,...)
    // <editor-fold> Constructor hàm dùng để khởi tạo đối tượng
    public Student() {
    }

    public Student(String id, String name, int age, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    // </editor-fold>

    // <editor-fold> Getter/Setter hàm để truy vấn thông tin private trong Fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18)
            this.age = age;
        else
            System.out.println("Sinh viên phải đủ 18 tuổi!");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    // </editor-fold>

    // Các methods hành vi khác của đối tượng
    public void hello() {
        System.out.println("Xin chào các bạn! Tôi tên là " + this.name + "!");
    }
    public void input(Scanner sc) {
        System.out.print("Nhập mã sinh viên: ");
        this.id = sc.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        this.name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập email: ");
        this.email = sc.nextLine();
        System.out.print("Nhập SĐT: ");
        this.phone = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.address = sc.nextLine();
        System.out.println("=====");

    }
    public void print() {
        System.out.println("Mã sinh viên: " + this.id);
        System.out.println("Tên: " + this.name);
        System.out.println("Tuổi: " + this.age);
        System.out.println("Email: " + this.email);
        System.out.println("SĐT: " + this.phone);
        System.out.println("Địa chỉ: " + this.address);
        System.out.println("======");
    }
}