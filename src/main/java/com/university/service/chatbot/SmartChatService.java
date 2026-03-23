package com.university.service.chatbot;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.data.message.SystemMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmartChatService {

    private final ChatAssistant assistant;

    public SmartChatService(
            @Value("${groq.api.key}") String apiKey,
            @Value("${groq.api.url}") String apiUrl) {

        // ⚙️ Cấu hình model Groq (OpenAI-compatible)
        var model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .baseUrl(apiUrl)
                .modelName("llama-3.3-70b-versatile")
                .temperature(0.7)
                .build();

        // 🧩 Bộ nhớ hội thoại (lưu tối đa 5 tin gần nhất)
        var memory = MessageWindowChatMemory.withMaxMessages(10);

        // 🧠 Thêm system message thủ công nếu version chưa có .systemMessage()
        memory.add(SystemMessage.from("""
                    Bạn là trợ lý ảo học vụ của hệ thống quản lý đại học.
                    Hãy hỗ trợ sinh viên và giảng viên về:
                    - Thông tin sinh viên, ngành học, học phí, lịch học
                    - Quy trình đăng ký, tốt nghiệp, và tài khoản
                    Trả lời ngắn gọn, dễ hiểu, lịch sự bằng tiếng Việt.
                """));

        // 🧠 Khởi tạo Assistant
        this.assistant = AiServices.builder(ChatAssistant.class)
                .chatLanguageModel(model)
                .chatMemory(memory)
                .build();
    }

    public String chat(String message) {
        return assistant.reply(message);
    }

    interface ChatAssistant {
        String reply(String message);
    }
}
