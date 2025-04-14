package com.greenacademy;

public class Application {
    public static void main(String[] args) {
        swapInt(5, 6);
        swapStr("A", "B");
        swap('E', 'F');
        swap(88, 63);
    }

    public static void swapInt(int a, int b) {
        System.out.println("before: a = " + a + " | b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("after: a = " + a + " | b = " + b);
    }

    public static void swapStr(String a, String b) {
        System.out.println("before: a = " + a + " | b = " + b);
        String temp = a;
        a = b;
        b = temp;
        System.out.println("after: a = " + a + " | b = " + b);
    }

    public static <T> void swap(T a, T b) {
        System.out.println("before: a = " + a + " | b = " + b);
        T temp = a;
        a = b;
        b = temp;
        System.out.println("after: a = " + a + " | b = " + b);
    }
}
