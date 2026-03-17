package com.university.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.university.dto.request.ContactMessageRequest;

import jakarta.mail.internet.MimeMessage;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactMessageService {

    private final JavaMailSender mailSender;

    @Value("${MAIL_USERNAME}")
    private String acceptedMail;

    @Async
    public CompletableFuture<Void> sendContactEmail(ContactMessageRequest request) {
        try {
            log.info("Start sending contact email from: {}", request.getName());

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(acceptedMail); // admin nhận
            helper.setReplyTo(request.getEmail()); // email người dùng
            helper.setSubject("Liên hệ từ: " + request.getName());
            helper.setText(buildEmailContent(request), false);

            // Set timezone Vietnam
            ZonedDateTime hcmTime = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
            String rfcDate = DateTimeFormatter.RFC_1123_DATE_TIME.format(hcmTime);
            mimeMessage.setHeader("Date", rfcDate);

            mailSender.send(mimeMessage);

            log.info("Send mail SUCCESS to {}", acceptedMail);

            return CompletableFuture.completedFuture(null);

        } catch (Exception e) {
            log.error("Send mail FAILED", e);
            return CompletableFuture.failedFuture(
                    new RuntimeException("Gửi email thất bại"));
        }
    }

    private String buildEmailContent(ContactMessageRequest request) {
        return String.format(
                "Tên: %s\nEmail: %s\n\nNội dung:\n%s",
                request.getName(),
                request.getEmail(),
                request.getMessage());
    }
}