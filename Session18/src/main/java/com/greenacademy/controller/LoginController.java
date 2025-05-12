package com.greenacademy.controller;

import com.greenacademy.config.SessionConfig;
import com.greenacademy.config.ViewConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) req.setAttribute("username", cookie.getValue());
                if (cookie.getName().equals("password")) req.setAttribute("password", cookie.getValue());
                if (cookie.getName().equals("remember")) req.setAttribute("remember", cookie.getValue());
            }
        }

        req.getRequestDispatcher(ViewConfig.PREFIX + "login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean remember = Boolean.parseBoolean(req.getParameter("remember"));
        HttpSession session = req.getSession();
        if (username.equals("admin") && password.equals("admin")) {
            session.setAttribute(SessionConfig.USER, username);
            if (remember) {
                Cookie userCookie = new Cookie("username", username);
                Cookie pasCookie = new Cookie("password", password);
                Cookie remberCookie = new Cookie("remember", remember+"");
                resp.addCookie(userCookie);
                resp.addCookie(pasCookie);
                resp.addCookie(remberCookie);
            } else {
                Cookie[] cookies = req.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        cookie.setMaxAge(0);
                        resp.addCookie(cookie);
                    }
                    if (cookie.getName().equals("password")) {
                        cookie.setMaxAge(0);
                        resp.addCookie(cookie);
                    }
                    if (cookie.getName().equals("remember")) {
                        cookie.setMaxAge(0);
                        resp.addCookie(cookie);
                    }
                }
            }
            resp.sendRedirect("/admin");
        } else
            req.getRequestDispatcher(ViewConfig.PREFIX + "login.jsp").forward(req, resp);
    }
}
