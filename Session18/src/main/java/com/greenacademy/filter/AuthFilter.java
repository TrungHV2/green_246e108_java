package com.greenacademy.filter;

import com.greenacademy.config.SessionConfig;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "authFilter", urlPatterns = {"/admin", "/admin/*"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        System.out.printf("[%s] %s at %s\n", httpRequest.getMethod(), httpRequest.getRequestURI(), new Date());
        HttpSession session = httpRequest.getSession();
        if (session.getAttribute(SessionConfig.USER) == null) {
            httpResponse.sendRedirect("/login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
