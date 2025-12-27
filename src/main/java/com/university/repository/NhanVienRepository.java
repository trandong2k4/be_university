package com.university.repository;

import com.university.dto.response.NhanVienResponseDTO.NhanVienView;
import com.university.entity.NhanVien;
import com.university.enums.ViTriEnum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    List<NhanVien> findByViTri(ViTriEnum viTri);

    @Query("""
            SELECT
                n.id AS id,
                u.username AS username
            FROM NhanVien n
            JOIN n.user u
            WHERE u.id = :userId
            """)
    Optional<NhanVienView> findByUserId(UUID userId);

}
