package com.greenacademy.controller;

import com.greenacademy.entity.Book;
import com.greenacademy.entity.Category;
import com.greenacademy.model.Repository;
import com.greenacademy.model.impl.BookRepository;
import com.greenacademy.model.impl.CategoryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "bookEdit", value = "/book-edit")
public class BookEditController extends HttpServlet {
    private Repository<Book, String> bookRepository;
    private Repository<Category, Integer> categoryRepository;

    public BookEditController() {
        bookRepository = new BookRepository();
        categoryRepository = new CategoryRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String bookId = req.getParameter("bookId");
        Book book = bookRepository.findById(bookId);
        List<Category> categories = categoryRepository.findAll();
        req.setAttribute("book", book);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/views/book/book-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        String author = req.getParameter("author");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        double price = Double.parseDouble(req.getParameter("price"));
        Book book = new Book(bookId, bookName, author, categoryId, price);
        Repository<Book, String> bookRepository = new BookRepository();
        bookRepository.update(book);
        resp.sendRedirect("/book-list");
    }
}
