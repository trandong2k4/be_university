package com.university.repository;

import com.university.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    List<NhanVien> findByViTriId(UUID viTriId);

    List<NhanVien> findByNgayNghiViecIsNull(); // Nhân viên đang làm việc
}
