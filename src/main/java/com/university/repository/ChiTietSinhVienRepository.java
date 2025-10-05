package com.university.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.university.entity.ChiTietSinhVien;

@Repository
public interface ChiTietSinhVienRepository extends JpaRepository<ChiTietSinhVien, UUID> {

    @Query("SELECT c FROM ChiTietSinhVien c WHERE LOWER(c.sinhVien.hoTen) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<ChiTietSinhVien> searchByTenSinhVien(@Param("keyword") String keyword);

    Optional<ChiTietSinhVien> findBySinhVienId(UUID sinhVienId);
}
