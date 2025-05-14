package com.greenacademy.controller;

import com.greenacademy.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") String id, Model model) {
        model.addAttribute("stdId", id);
        return "details";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Student student = new Student();
        student.setId("DF0001");
        model.addAttribute("st", student);
        return "add-student";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Student st, Model model) {
        model.addAttribute("std", st);
        return "student-info";
    }
}
