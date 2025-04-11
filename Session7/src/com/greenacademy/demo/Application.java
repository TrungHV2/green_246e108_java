package com.greenacademy.demo;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("A John1", "Smith", 18));
        students.add(new Student("B John2", "Smith", 20));
        students.add(new Student("D John3", "Smith", 35));
        students.add(new Student("E John4", "Smith", 24));
        students.add(new Student("C John5", "Smith", 22));

        Collections.sort(students);

        Collections.sort(students, (st1, st2) -> st1.getId().compareTo(st2.getId()));

        for (Student student : students) {
            System.out.println(student);
        }

        Set<String> strings = new HashSet<>();
        strings.add("F");
        strings.add("H");
        strings.add("Z");
        strings.add("A");
        strings.add("B");
        strings.add("A");
        strings.add("D");
        strings.add("A");

        for (String str : strings) {
            System.out.println(str);
        }

        SortedSet<String> names = new TreeSet<>(strings);

        for (String name : names) {
            System.out.println(name);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 5);
        map.put("A", 6);
        map.put("A", 9);
        map.put("B", 1);
        map.put("C", 2);
        map.put("D", 3);


        for (Integer num : map.values()) {
            System.out.println(num.toString());
        }
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        Map<String, Student> map2 = new HashMap<>();
        map2.put("A", new Student("A", "Smith1", 18));
        map2.put("B", new Student("B", "Smith2", 20));
        map2.put("C", new Student("C", "Smith3", 22));
    }
}
