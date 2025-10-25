package com.university.service;

import com.university.entity.ChatLog;
import com.university.repository.ChatLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatLogService {

    private final ChatLogRepository repo;

    public void save(UUID userId, String role, String content) {
        repo.save(ChatLog.builder()
                .userId(userId)
                .role(role)
                .content(content)
                .build());
    }

    public List<ChatLog> getHistory(UUID userId) {
        return repo.findByUserIdOrderByCreatedAtAsc(userId);
    }
}
