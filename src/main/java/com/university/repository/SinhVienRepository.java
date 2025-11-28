package com.university.repository;

import com.university.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, UUID> {

        @Query("SELECT sv FROM SinhVien sv WHERE LOWER(sv.hoTen) LIKE LOWER(CONCAT('%', :keyword, '%'))")
        List<SinhVien> searchByHoTen(@Param("keyword") String keyword);

        Optional<SinhVien> findByMaSinhVien(String maSinhVien);

        Optional<SinhVien> findByUser_Id(UUID userId);

        @Query("SELECT COUNT(sv) FROM SinhVien sv WHERE sv.ngayTotNghiep IS NULL")
        long countByNgayTotNghiepIsNull();

        @Query("SELECT COUNT(sv) FROM SinhVien sv WHERE sv.ngayTotNghiep IS NOT NULL")
        long countByNgayTotNghiepIsNotNull();

        @Query("SELECT n.tenNganh, COUNT(s.id) FROM SinhVien s JOIN s.nganh n WHERE s.nganh IS NOT NULL GROUP BY n.tenNganh")
        List<Object[]> countByNganhRaw();

        @Query("SELECT EXTRACT(YEAR FROM s.ngayNhapHoc), COUNT(s.id) FROM SinhVien s WHERE s.ngayNhapHoc IS NOT NULL GROUP BY EXTRACT(YEAR FROM s.ngayNhapHoc)")
        List<Object[]> countByNamNhapHocRaw();
}
