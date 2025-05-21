package com.greenacademy.service;

import com.greenacademy.model.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> findBy(String name, String author, Double price);
}
