package com.university.repository;

import com.university.entity.SinhVien;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SinhVienRepository extends JpaRepository<SinhVien, UUID> {
    List<SinhVien> findByHoTenContainingIgnoreCase(String keyword);

}
