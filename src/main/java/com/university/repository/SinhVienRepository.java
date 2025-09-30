package com.university.repository;

import com.university.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, UUID> {
    boolean existsByMaSinhVien(String maSinhVien);
}
