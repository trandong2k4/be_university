package com.university.repository;

import com.university.entity.PhongHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhongHocRepository extends JpaRepository<PhongHoc, UUID> {
    boolean existsByMaPhongHoc(String maPhongHoc);
}
