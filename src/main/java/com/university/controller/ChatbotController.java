package com.university.controller;

import com.university.entity.ChatLog;
import com.university.entity.User;
import com.university.service.chatbot.ChatLogService;
import com.university.service.chatbot.SmartChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chatbot")
@RequiredArgsConstructor
public class ChatbotController {

    private final SmartChatService smartChatService;
    private final ChatLogService chatLogService;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody Map<String, String> body) {
        String message = body.get("message");
        try {
            String response = smartChatService.chat(message);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("❌ Lỗi xử lý chatbot: " + e.getMessage());
        }
    }

    @PostMapping("/chat/{userId}")
    public ResponseEntity<String> chat(@PathVariable User user, @RequestBody Map<String, String> body) {
        String message = body.get("message");

        try {
            // Lưu tin nhắn user
            chatLogService.save(user, "user", message);

            String response = smartChatService.chat(message);

            // Lưu phản hồi AI
            chatLogService.save(user, "bot", response);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("❌ Lỗi chatbot: " + e.getMessage());
        }
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<ChatLog>> getHistory(@PathVariable User user) {
        return ResponseEntity.ok(chatLogService.getHistory(user));
    }

}