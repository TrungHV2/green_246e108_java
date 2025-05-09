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
import java.util.List;

@WebServlet(name = "bookList", value = "/book-list")
public class BookListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Repository<Book, String> bookRepository = new BookRepository();
        List<Book> data = bookRepository.findAll();
        req.setAttribute("data", data);
        req.getRequestDispatcher("/WEB-INF/views/book/book-list.jsp").forward(req, resp);
    }
}
