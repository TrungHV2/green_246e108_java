package com.greenacademy.controller;

import com.greenacademy.entity.Book;
import com.greenacademy.model.Repository;
import com.greenacademy.model.impl.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookDel", value = "/book-delete")
public class BookDelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Repository<Book, String> bookRepository = new BookRepository();
        String bookId = req.getParameter("bookId");
        bookRepository.delete(bookId);
        resp.sendRedirect("/book-list");
    }
}
