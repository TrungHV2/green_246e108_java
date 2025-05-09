package com.greenacademy.controller;

import com.greenacademy.entity.Category;
import com.greenacademy.model.Pageable;
import com.greenacademy.model.Repository;
import com.greenacademy.model.impl.CategoryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "categories", value = "/categories")
public class CategoryController extends HttpServlet {
    private Repository<Category, Integer> categoryRepository;

    public CategoryController() {
        categoryRepository = new CategoryRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") == null ? "list" : req.getParameter("action");
        switch (action) {
            case "create":
                req.getRequestDispatcher("/WEB-INF/views/categories/create.jsp").forward(req, resp);
                break;
            case "edit":
                req.getRequestDispatcher("/WEB-INF/views/categories/edit.jsp").forward(req, resp);
                break;
            case "list":
            default:
                int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
                Pageable<Category> pageable = categoryRepository.pagination(page, 3);
                req.setAttribute("pageable", pageable);
                req.getRequestDispatcher("/WEB-INF/views/categories/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "edit":
                break;
            case "create":
            default:

                break;
        }
        resp.sendRedirect("/categories");
    }
}
