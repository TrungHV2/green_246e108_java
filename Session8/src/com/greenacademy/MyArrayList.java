package com.greenacademy;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] elements;
    private int index;

    public MyArrayList() {
        elements = new Object[10];
    }

    public void add(T element) {
        if (index == elements.length) {
            elements = Arrays.copyOf(elements, elements.length + 10);
        }
        elements[index++] = element;
    }
}
