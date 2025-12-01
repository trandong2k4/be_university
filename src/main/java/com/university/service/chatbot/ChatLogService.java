package com.university.service.chatbot;

import com.university.entity.ChatLog;
import com.university.entity.User;
import com.university.repository.ChatLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatLogService {

    private final ChatLogRepository repo;

    public void save(User user,String role, String content) {
        repo.save(ChatLog.builder()
                .user(user)
                .role(role)
                .content(content)
                .build());
    }

    public List<ChatLog> getHistory(User user) {
        return repo.findByUserIdOrderByCreatedAtAsc(user);
    }
}
