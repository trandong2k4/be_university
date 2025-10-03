package com.university.repository;

import com.university.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {
    List<Permission> findByMaPermissionContainingIgnoreCase(String maPermission);

    Optional<Permission> findByMaPermission(String maPermission);

}
