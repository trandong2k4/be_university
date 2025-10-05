package com.university.repository;

import com.university.entity.KiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KiHocRepository extends JpaRepository<KiHoc, UUID> {

    @Query("SELECT k FROM KiHoc k WHERE LOWER(k.tenKiHoc) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<KiHoc> searchByTenKiHoc(@Param("keyword") String keyword);
}
