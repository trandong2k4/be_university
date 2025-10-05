package com.university.repository;

import com.university.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, UUID> {

        @Query("SELECT sv FROM SinhVien sv WHERE LOWER(sv.hoTen) LIKE LOWER(CONCAT('%', :keyword, '%'))")
        List<SinhVien> searchByHoTen(@Param("keyword") String keyword);

        Optional<SinhVien> findByMaSinhVien(String maSinhVien);

        @Query("SELECT COUNT(sv) FROM SinhVien sv WHERE sv.ngayTotNghiep IS NULL")
        long countByNgayTotNghiepIsNull();

        @Query("SELECT COUNT(sv) FROM SinhVien sv WHERE sv.ngayTotNghiep IS NOT NULL")
        long countByNgayTotNghiepIsNotNull();

        @Query("SELECT sv.nganh.tenNganh, COUNT(sv) FROM SinhVien sv GROUP BY sv.nganh.tenNganh")
        Map<String, Long> countByNganh();

        @Query("SELECT YEAR(sv.ngayNhapHoc), COUNT(sv) FROM SinhVien sv GROUP BY YEAR(sv.ngayNhapHoc)")
        Map<Integer, Long> countByNamNhapHoc();
}
