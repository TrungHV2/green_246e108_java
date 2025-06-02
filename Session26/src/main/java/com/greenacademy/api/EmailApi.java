package com.greenacademy.api;

import com.greenacademy.model.request.SendEmailRequest;
import com.greenacademy.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/api/email")
public class EmailApi {
    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody SendEmailRequest request) {
        emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody());
        return ResponseEntity.ok("Email sent");
    }
    @PostMapping(value = "/send-attachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> sendAttachment(@RequestPart("to") String to,
                                            @RequestPart("subject") String subject,
                                            @RequestPart("body") String body,
                                            @RequestPart("file") MultipartFile file) {
        emailService.sendEmail(to, subject, body, file);
        return ResponseEntity.ok("Email sent");
    }
}
