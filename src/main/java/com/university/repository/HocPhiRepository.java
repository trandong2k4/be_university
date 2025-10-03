package com.university.repository;

import com.university.entity.HocPhi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface HocPhiRepository extends JpaRepository<HocPhi, UUID> {

    List<HocPhi> findByTrangThai(String trangThai);

    List<HocPhi> findByKiHocId(UUID kiHocId);

    List<HocPhi> findBySinhVienId(UUID sinhVienId);

    List<HocPhi> findByHanThanhToanBefore(LocalDate date);

    List<HocPhi> findByNgayThanhToanIsNullAndHanThanhToanBefore(LocalDate date); // trễ hạn chưa thanh toán
}
