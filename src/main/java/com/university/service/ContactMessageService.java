package com.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.university.dto.request.ContactMessageRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import jakarta.mail.internet.MimeMessage;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class ContactMessageService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${MAIL_USERNAME}")
    private String acceptedMail;

    @Async
    public void sendContactEmail(ContactMessageRequest request) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(acceptedMail);
            helper.setSubject("Liên hệ từ: " + request.getName());
            helper.setText("Nội dung: " + request.getMessage());

            // ÉP GIỜ VIỆT NAM VÀO HEADER
            java.time.ZonedDateTime hcmTime = java.time.ZonedDateTime.now(java.time.ZoneId.of("Asia/Ho_Chi_Minh"));
            String rfcDate = java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME.format(hcmTime);

            mimeMessage.setHeader("Date", rfcDate); // Ép cứng nhãn thời gian vào email

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}