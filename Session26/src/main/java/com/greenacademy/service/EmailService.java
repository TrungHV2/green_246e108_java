package com.greenacademy.service;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
    void sendEmail(String to, String subject, String body, MultipartFile multipart);
}
