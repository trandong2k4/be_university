package com.university.repository;

import com.university.dto.response.UserResponseDTO.UserView;
import com.university.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);

    @Query("""
            SELECT
                u.id AS id,
                u.username AS username,
                u.email AS email
            FROM User u
            WHERE u.id = :userId
            """)
    Optional<UserView> findByUserId(UUID userId);

    @Query("""
            SELECT
                u.id AS id,
                u.username AS username,
                u.email AS email,
                u.status AS status,
                u.note AS note,
                u.createDate AS createDate,
                u.updateDate AS updateDate,
                u.role.id AS roleId
            FROM User u
            """)
    List<UserView> findAllUserViews();
}
