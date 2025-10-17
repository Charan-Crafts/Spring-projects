package com.growandshine.Journal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public ResponseEntity<String> sendEmail(String to, String subject, String body) {

        try {
            // Validate inputs
            if (to == null || to.trim().isEmpty()) {
                return new ResponseEntity<>("Email address is required", HttpStatus.BAD_REQUEST);
            }

//            if (subject == null || subject.trim().isEmpty()) {
//                return new ResponseEntity<>("Subject is required", HttpStatus.BAD_REQUEST);
//            }

//            if (body == null || body.trim().isEmpty()) {
//                return new ResponseEntity<>("Body is required", HttpStatus.BAD_REQUEST);
//            }

            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(fromEmail);  // ✅ Add this - important!
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);

            javaMailSender.send(mail);

            System.out.println("Email sent successfully to: " + to);
            return new ResponseEntity<>("Email sent to " + to, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>("Failed to send email: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}