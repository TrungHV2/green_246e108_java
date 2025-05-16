package com.greenacademy.controller;

import com.greenacademy.entity.BookEntity;
import com.greenacademy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = {"", "/index"})
    public String index(Model model) {
        List<BookEntity> books = bookRepository.findAll();
        for (BookEntity book : books) {
            System.out.println(book.getCategory().getName());
        }
        model.addAttribute("books", books);
        return "books/index";
    }
}
