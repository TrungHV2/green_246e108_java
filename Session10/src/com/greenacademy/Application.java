package com.greenacademy;

import com.greenacademy.model.Product;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        Product p = new Product();
        try {
            System.out.print("Mã sp: ");
            p.setProductId(sc.nextLine());
            System.out.print("Enter a = ");
            a = Integer.parseInt(sc.nextLine());
            int b = 9 / a;
        } catch (NumberFormatException e) {
            System.err.println("Sai định dạng số!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Luôn thực thi dù có xảy ra exception hay không");
        }
        System.out.println("a = " + a);
    }
}
