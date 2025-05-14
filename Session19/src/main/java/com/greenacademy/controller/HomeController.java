package com.greenacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping(value = {"", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("message", "Hello World");
        return "index";
    }
}
