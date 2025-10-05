package com.university.repository;

import com.university.entity.LoaiTinChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoaiTinChiRepository extends JpaRepository<LoaiTinChi, UUID> {

    @Query("SELECT l FROM LoaiTinChi l WHERE LOWER(l.tenLoaiTinChi) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<LoaiTinChi> searchByTenLoaiTinChi(@Param("keyword") String keyword);

    Optional<LoaiTinChi> findByMaLoaiTinChi(String maLoaiTinChi);
}
