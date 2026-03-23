package com.university.repository;

import com.university.entity.DangKyTinChi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DangKyTinChiRepository extends JpaRepository<DangKyTinChi, UUID> {

  @Query("SELECT d FROM DangKyTinChi d WHERE d.sinhVien.id = :sinhVienId")
  List<DangKyTinChi> findBySinhVienId(@Param("sinhVienId") UUID sinhVienId);

  @Query("SELECT d FROM DangKyTinChi d WHERE d.lopHocPhan.id = :lopHocPhanId")
  List<DangKyTinChi> findByLopHocPhanId(@Param("lopHocPhanId") UUID lopHocPhanId);

  @Query("SELECT d FROM DangKyTinChi d WHERE d.lopHocPhan.id = :lopHocPhanId AND d.sinhVien.id = :sinhVienId")
  Optional<DangKyTinChi> findByLopHocPhanIdAndSinhVienId(@Param("lopHocPhanId") UUID lopHocPhanId,
      @Param("sinhVienId") UUID sinhVienId);

}
