package com.university.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.entity.ChiTietSinhVien;
import com.university.entity.SinhVien;

public interface ChiTietSinhVienRepository extends JpaRepository<ChiTietSinhVien, UUID> {
    List<ChiTietSinhVien> findByDiaChiContainingIgnoreCase(String keyword);

    Optional<ChiTietSinhVien> findBySinhVien(SinhVien sinhVien);
}
