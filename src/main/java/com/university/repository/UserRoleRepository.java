package com.university.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.university.entity.Role;
import com.university.entity.User;
import com.university.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    boolean existsByUserAndRole(User user, Role role);
}
