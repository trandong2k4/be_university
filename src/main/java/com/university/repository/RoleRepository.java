package com.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.university.entity.Role;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Role> findByMaRoleContainingIgnoreCase(String maRole);

    Optional<Role> findByMaRole(String maRole);
}
