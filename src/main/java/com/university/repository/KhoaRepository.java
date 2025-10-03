package com.university.repository;

import com.university.entity.Khoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KhoaRepository extends JpaRepository<Khoa, UUID> {
    Page<Khoa> findByTruongId(UUID truongId, Pageable pageable);
}
