package com.university.repository;

import com.university.entity.KiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KiHocRepository extends JpaRepository<KiHoc, UUID> {
    boolean existsByMaKiHoc(String maKiHoc);
}
