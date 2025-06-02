package com.greenacademy.model.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SendEmailRequest {
    private String to;
    private String subject;
    private String body;
}
