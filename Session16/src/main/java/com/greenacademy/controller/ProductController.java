package com.greenacademy.controller;

import com.greenacademy.model.ProductService;
import com.greenacademy.model.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "product", value = "/product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        ProductService service = new ProductService();
        List<Product> data = service.getAll();

        // Set dữ liệu và request
        req.setAttribute("data", data);
        req.setAttribute("id", id);
        // Chuyển tiếp đến JSP gồm cả request (có mang dữ liệu vừa set) và response
        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }
}
