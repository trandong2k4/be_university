package com.university.repository;

import com.university.entity.ChatLog;
import com.university.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ChatLogRepository extends JpaRepository<ChatLog, UUID> {
    List<ChatLog> findByUserIdOrderByCreatedAtAsc(User user);
}
