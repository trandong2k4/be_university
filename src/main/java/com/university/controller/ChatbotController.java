package com.university.controller;

import com.university.entity.ChatLog;
import com.university.service.chatbot.ChatLogService;
import com.university.service.chatbot.SmartChatService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public ResponseEntity<String> chat(@PathVariable UUID userId, @RequestBody Map<String, String> body) {
        String message = body.get("message");

        try {
            // Lưu tin nhắn user
            chatLogService.save(userId, "user", message);

            String response = smartChatService.chat(message);

            // Lưu phản hồi AI
            chatLogService.save(userId, "bot", response);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("❌ Lỗi chatbot: " + e.getMessage());
        }
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<ChatLog>> getHistory(@PathVariable UUID userId) {
        return ResponseEntity.ok(chatLogService.getHistory(userId));
    }

}

// package com.university.controller;

// import com.university.service.ChatbotService;
// import lombok.RequiredArgsConstructor;

// import java.util.Map;
// import org.json.JSONObject;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/chatbot")
// @RequiredArgsConstructor
// public class ChatbotController {

// private final ChatbotService chatbotService;

// @PostMapping("/chat")
// public ResponseEntity<String> chat(@RequestBody Map<String, String> body) {
// String message = body.get("message");

// try {
// String json = chatbotService.chat(message);
// JSONObject obj = new JSONObject(json);

// // Log để bạn có thể xem khi debug
// System.out.println("Groq JSON response: " + json);

// // Groq có thể trả text ở nhiều vị trí khác nhau
// String content = null;

// // 1️⃣ Thử đọc theo kiểu OpenAI (message.content)
// if (obj.has("choices")) {
// JSONObject firstChoice = obj.getJSONArray("choices").getJSONObject(0);
// if (firstChoice.has("message") &&
// firstChoice.getJSONObject("message").has("content")) {
// content = firstChoice.getJSONObject("message").getString("content").trim();
// }
// // 2️⃣ Nếu không có message.content, thử trường text
// else if (firstChoice.has("text")) {
// content = firstChoice.getString("text").trim();
// }
// }

// if (content == null || content.isEmpty()) {
// content = "⚠️ Không nhận được phản hồi hợp lệ từ Groq model.";
// }

// return ResponseEntity.ok(content);

// } catch (Exception e) {
// return ResponseEntity.internalServerError().body("Lỗi khi xử lý chatbot: " +
// e.getMessage());
// }
// }

// }