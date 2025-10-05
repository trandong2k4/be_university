package com.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.university.entity.Role;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    @Query("SELECT r FROM Role r WHERE LOWER(r.maRole) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Role> searchByMaRole(@Param("keyword") String keyword);

    Optional<Role> findByMaRole(String tenRole);
}
