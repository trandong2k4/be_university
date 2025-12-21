package com.university.repository;

import com.university.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, UUID> {

}
