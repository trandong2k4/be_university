package com.university.repository;

import com.university.entity.PhongHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface PhongHocRepository extends JpaRepository<PhongHoc, UUID> {
    List<PhongHoc> findByToaNhaContainingIgnoreCase(String toaNha);

    List<PhongHoc> findByTang(Integer tang);

    List<PhongHoc> findBySucChuaGreaterThanEqual(Integer sucChua);

    List<PhongHoc> findByTangAndSucChuaGreaterThanEqual(Integer tang, Integer sucChua);

}
