package com.greenacademy.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ExcelService {
    void export(HttpServletResponse response) throws IOException;
}
