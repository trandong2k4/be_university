package com.university.repository;

import com.university.entity.Nganh;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NganhRepository extends JpaRepository<Nganh, UUID> {
    Page<Nganh> findByKhoaId(UUID khoaId, Pageable pageable);

    Optional<Nganh> findByMaNganh(String maNganh);
}
