package com.university.repository;

import com.university.entity.GioHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHocRepository extends JpaRepository<GioHoc, UUID> {

    @Query("SELECT g FROM GioHoc g WHERE LOWER(g.tenGioHoc) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<GioHoc> searchByTenGioHoc(@Param("keyword") String keyword);
}
