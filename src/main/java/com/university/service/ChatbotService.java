package com.university.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.*;
import java.util.*;

@Service
public class ChatbotService {

  @Value("${groq.api.key}")
  private String apiKey;

  @Value("${groq.api.url}")
  private String apiUrl;

  // 🧩 Bộ nhớ hội thoại tạm (trong RAM)
  private final List<Map<String, String>> conversation = new ArrayList<>();

  public String chat(String message) throws Exception {
    // Thêm tin nhắn người dùng
    conversation.add(Map.of("role", "user", "content", message));

    // Giới hạn bộ nhớ hội thoại (ví dụ 10 tin nhắn gần nhất)
    if (conversation.size() > 10) {
      conversation.remove(0);
    }

    // Tạo payload JSON từ hội thoại
    StringBuilder msgBuilder = new StringBuilder("[");
    for (Map<String, String> m : conversation) {
      msgBuilder.append(String.format("""
              {"role": "%s", "content": "%s"},
          """, m.get("role"), m.get("content").replace("\"", "\\\"")));
    }
    msgBuilder.append("]");

    String payload = """
            {
              "model": "llama-3.3-70b-versatile",
              "messages": %s
            }
        """.formatted(msgBuilder.toString());

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(apiUrl))
        .header("Authorization", "Bearer " + apiKey)
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(payload))
        .build();

    HttpClient client = HttpClient.newHttpClient();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    return response.body();
  }

  // 🧹 Cho phép reset hội thoại
  public void clearConversation() {
    conversation.clear();
  }
}
