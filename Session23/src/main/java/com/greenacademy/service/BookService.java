package com.greenacademy.service;

import com.greenacademy.model.BookRequest;
import com.greenacademy.model.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> findAll();
    BookResponse findId(String id);
    BookResponse save(BookRequest book);
}
