package com.greenacademy.demo;

public class StudentManager {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        studentService.save(new Student("SV01", "Doe1", 19));
        studentService.save(new Student("SV02", "Doe2", 20));
        studentService.save(new Student("SV03", "Doe3", 30));
        studentService.save(new Student("SV04", "Doe4", 35));
        studentService.save(new Student("SV05", "Doe5", 22));

        for (Student st : studentService.where(new PredicateStudentByName("5"))) {
            System.out.println(st);
        }

        for (Student st : studentService.where(new PredicateStudentByAge(20))) {
            System.out.println(st);
        }

        for (Student st : studentService.where(new PredicateStudent() {
            @Override
            public boolean test(Student student) {
                return student.getAge() >= 20 && student.getAge() <= 30;
            }
        })) {
            System.out.println(st);
        }
        for (Student st : studentService.where((student) -> {
            return student.getAge() >= 20 && student.getAge() <= 30;
        })) {
            System.out.println(st);
        }
        for (Student st : studentService.where(student -> student.getAge() >= 20 && student.getAge() <= 30)) {
            System.out.println(st);
        }
    }
}
class PredicateStudentByName implements PredicateStudent {
    private String keyword;

    public PredicateStudentByName(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean test(Student student) {
        return student.getName().contains(keyword);
    }
}

class PredicateStudentByAge implements PredicateStudent {
    private int age;

    public PredicateStudentByAge(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Student student) {
        return student.getAge() == age;
    }
}