package com.university.repository;

import com.university.entity.NhanVien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    List<NhanVien> findByViTri_TenViTri(String tenViTri);

    @Query("SELECT v.tenViTri, COUNT(n) FROM NhanVien n JOIN n.viTri v WHERE v.tenViTri LIKE %:keyword% GROUP BY v.tenViTri")
    List<Object[]> countNhanVienByViTri(@Param("keyword") String keyword);
}
