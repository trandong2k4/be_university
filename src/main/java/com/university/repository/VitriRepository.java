package com.university.repository;

import com.university.entity.ViTri;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ViTriRepository extends JpaRepository<ViTri, UUID> {
    List<ViTri> findByMaViTriContainingIgnoreCaseOrTenViTriContainingIgnoreCase(String ma, String ten);
}
