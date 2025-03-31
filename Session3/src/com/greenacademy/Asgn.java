package com.greenacademy;

import java.util.Scanner;

public class Asgn {
    public static void main(String[] args) {
        /**
         * Sử dụng class Student vừa tạo, viết chương trình cho phép nhập
         * vào danh sách N (N nhập từ bàn phím) sinh viên.
         * Nhập thông tin cho từng sinh viên và Hiển thị danh sách sinh
         * viên vừa nhập.
         */
        Scanner sc = new Scanner(System.in);
//        Student st = new Student();
//        st.input(sc);
//        st.print();
        Student[] students = null;
        int choose;
        while (true) {
            System.out.println("********MENU********");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị d/s sinh viên");
            // BTVN: Thực hiện các y/c sau
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Sắp xếp d/s sinh viên theo tên A-Z");
            System.out.println("5. Sắp xếp sinh viên theo tuổi giảm dần");
            // BTVN
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.print("Số sinh viên cần lưu: ");
                    int n = Integer.parseInt(sc.nextLine());
                    students = new Student[n];
                    System.out.println("___Nhập thông tin___");
                    for (int i = 0; i < n; i++) {
                        students[i] = new Student();
                        students[i].input(sc);
                    }
                    break;
                case 2:
                    System.out.println("DANH SÁCH SINH VIÊN");
                    for (Student st : students)
                        st.print();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn chọn sai chức năng!");
                    break;
            }
        }
    }
}
