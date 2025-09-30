package com.university.repository;

import com.university.entity.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaiVietRepository extends JpaRepository<BaiViet, UUID> {
}
