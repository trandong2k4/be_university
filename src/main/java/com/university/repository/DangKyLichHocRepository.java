package com.university.repository;

import com.university.entity.DangKyLichHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DangKyLichHocRepository extends JpaRepository<DangKyLichHoc, UUID> {

    @Query("SELECT d FROM DangKyLichHoc d WHERE d.sinhVien.id = :sinhVienId")
    List<DangKyLichHoc> findBySinhVienId(@Param("sinhVienId") UUID sinhVienId);

    @Query("SELECT d FROM DangKyLichHoc d WHERE d.lichHoc.id = :lichHocId AND d.sinhVien.id = :sinhVienId")
    Optional<DangKyLichHoc> findByLichHocAndSinhVien(@Param("lichHocId") UUID lichHocId,
            @Param("sinhVienId") UUID sinhVienId);
}
