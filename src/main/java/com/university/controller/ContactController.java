package com.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.university.dto.request.ContactMessageRequest;
import com.university.service.ContactMessageService;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "*") // cho phép gọi từ frontend React
public class ContactController {

    @Autowired
    private ContactMessageService contactService;

    @PostMapping
    public String sendContact(@RequestBody ContactMessageRequest request) {
        contactService.sendContactEmail(request);
        return "Thông tin liên hệ đã được gửi thành công!";
    }
}
