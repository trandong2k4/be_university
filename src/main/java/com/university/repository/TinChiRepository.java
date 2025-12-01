package com.university.repository;

import com.university.entity.TinChi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface TinChiRepository extends JpaRepository<TinChi, UUID> {

    List<TinChi> findByMonHocId(UUID monHocId);

    List<TinChi> findByGiaTriTinChiGreaterThanEqual(BigDecimal giaTriTinChi);

}
