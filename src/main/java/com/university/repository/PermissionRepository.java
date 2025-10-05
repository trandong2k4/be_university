package com.university.repository;

import com.university.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {

    Optional<Permission> findByMaPermission(String maPermission);

    @Query("SELECT p FROM Permission p WHERE LOWER(p.maPermission) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Permission> searchByMaPermission(@Param("keyword") String keyword);
}
