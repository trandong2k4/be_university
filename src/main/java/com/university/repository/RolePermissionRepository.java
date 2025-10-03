package com.university.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.entity.Permission;
import com.university.entity.Role;
import com.university.entity.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, UUID> {
    boolean existsByRoleAndPermission(Role role, Permission permission);

    List<RolePermission> findByRole(Role role);

}
