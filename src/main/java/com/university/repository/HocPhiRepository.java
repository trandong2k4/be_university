package com.university.repository;

import com.university.entity.HocPhi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HocPhiRepository extends JpaRepository<HocPhi, UUID> {
}
