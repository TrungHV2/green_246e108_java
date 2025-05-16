package com.greenacademy.controller;

import com.greenacademy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value = {"", "/index"})
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("categories/index");
        view.addObject("data", categoryRepository.findAll());
        return view;
    }

}
