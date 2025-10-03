package com.university.repository;

import java.util.List;
import java.util.UUID;

import com.university.entity.DangKyLichHoc;
import com.university.entity.LichHoc;
import com.university.entity.SinhVien;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DangKyLichHocRepository extends JpaRepository<DangKyLichHoc, UUID> {
    boolean existsByLichHocAndSinhVien(LichHoc lichHoc, SinhVien sinhVien);

    List<DangKyLichHoc> findBySinhVienId(UUID sinhVienId);

    List<DangKyLichHoc> findBySinhVienIdAndLichHoc_KiHoc_Id(UUID sinhVienId, UUID kiHocId);
}
