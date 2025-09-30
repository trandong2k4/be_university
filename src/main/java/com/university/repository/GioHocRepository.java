package com.university.repository;

import com.university.entity.GioHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GioHocRepository extends JpaRepository<GioHoc, UUID> {
    boolean existsByMaGioHoc(String maGioHoc);
}
