package com.greenacademy.controller;

import com.greenacademy.model.BookResponse;
import com.greenacademy.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductApi {
    private final BookService bookService;

    @GetMapping("/list")
    public String list() {
        return "Hello World";
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String author,
                                 @RequestParam(required = false) Double price) {
        List<BookResponse> responses = bookService.findBy(name, author, price);

        return new ResponseEntity(responses, HttpStatus.OK);
    }
}
