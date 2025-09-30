package com.university.repository;

import com.university.entity.LichHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LichHocRepository extends JpaRepository<LichHoc, UUID> {
}
