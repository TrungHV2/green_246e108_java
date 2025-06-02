package com.greenacademy.service.impl;

import com.greenacademy.service.EmailService;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("trunghv.lsd@gmail.com");

        mailSender.send(message);
    }

    @Override
    public void sendEmail(String to, String subject, String body, MultipartFile file) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            helper.setFrom("trunghv.lsd@gmail.com");

            String fileName = file.getOriginalFilename();
            // Add attachment
            helper.addAttachment(fileName, file);
            mailSender.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
