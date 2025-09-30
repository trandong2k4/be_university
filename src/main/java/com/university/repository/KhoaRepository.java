package com.university.repository;

import com.university.entity.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, UUID> {
    boolean existsByMaKhoa(String maKhoa);
}
