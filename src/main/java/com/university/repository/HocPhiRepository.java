package com.university.repository;

import com.university.entity.HocPhi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface HocPhiRepository extends JpaRepository<HocPhi, UUID> {

    @Query("SELECT h FROM HocPhi h WHERE LOWER(h.sinhVien.hoTen) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<HocPhi> searchByTenSinhVien(@Param("keyword") String keyword);

    List<HocPhi> findBySinhVienId(UUID sinhVienId);

}
