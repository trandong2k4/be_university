package com.university.repository;

import com.university.entity.KetQuaHocTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface KetQuaHocTapRepository extends JpaRepository<KetQuaHocTap, UUID> {

    @Query("SELECT k FROM KetQuaHocTap k WHERE LOWER(k.sinhVien.hoTen) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<KetQuaHocTap> searchByTenSinhVien(@Param("keyword") String keyword);

    List<KetQuaHocTap> findBySinhVienId(UUID sinhVienId);
}