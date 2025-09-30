package com.university.repository;

import com.university.entity.ViTri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VitriRepository extends JpaRepository<ViTri, UUID> {
    boolean existsByMaViTri(String maViTri);
}
