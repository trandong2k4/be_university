package com.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.university.dto.request.ContactMessageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class ContactMessageService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${MAIL_USERNAME}")
    private String acceptedMail;

    public void sendContactEmail(ContactMessageRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(acceptedMail); // email nhận message.setTo("support@learninghub.edu.vn"); // email nhận
        message.setSubject("Liên hệ từ: " + request.getName());
        message.setText("Tên: " + request.getName() + "\n"
                + "Email: " + request.getEmail() + "\n\n"
                + "Nội dung:\n" + request.getMessage());

        mailSender.send(message);
    }
}
