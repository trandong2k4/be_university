package com.university.repository;

import com.university.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, UUID> {

    @Query("SELECT m FROM MonHoc m WHERE LOWER(m.tenMonHoc) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<MonHoc> searchByTenMonHoc(@Param("keyword") String keyword);

    Optional<MonHoc> findByMaMonHoc(String maMonHoc);

    @Query("""
                SELECT m
                FROM MonHoc m
                JOIN LichHoc l ON l.monHoc.id = m.id
                JOIN DangKyLichHoc dk ON dk.lichHoc.id = l.id
                JOIN SinhVien s ON s.id = dk.sinhVien.id
                WHERE s.user.id = :userId
            """)
    List<MonHoc> findByUserId(@Param("userId") UUID userId);

}
