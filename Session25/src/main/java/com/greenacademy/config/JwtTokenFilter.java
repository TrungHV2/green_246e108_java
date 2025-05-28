package com.greenacademy.config;

import com.greenacademy.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = parseJwtToken(request);
            // Validate token
            if (token != null && jwtUtils.validateJwtToken(token)) {
                String username = jwtUtils.getUsername(token);
                UserDetails userDetails = userService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception ex) {
            LOGGER.error("JwtTokenFilter doFilterInternal with exception {}", ex);
        }
        filterChain.doFilter(request, response);
    }

    private  String parseJwtToken(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (headerAuth != null && !headerAuth.isEmpty() && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }
}

