package com.university.repository;

import com.university.entity.PhongHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PhongHocRepository extends JpaRepository<PhongHoc, UUID> {

    @Query("SELECT p FROM PhongHoc p WHERE LOWER(p.tenPhong) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<PhongHoc> searchByTenPhong(@Param("keyword") String keyword);

    Optional<PhongHoc> findByMaPhong(String maPhong);
}
