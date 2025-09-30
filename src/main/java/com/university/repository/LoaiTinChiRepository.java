package com.university.repository;

import com.university.entity.LoaiTinChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoaiTinChiRepository extends JpaRepository<LoaiTinChi, UUID> {
    boolean existsByMaLoaiTinChi(String maLoaiTinChi);
}
