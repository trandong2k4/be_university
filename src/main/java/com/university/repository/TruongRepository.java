package com.university.repository;

import com.university.entity.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TruongRepository extends JpaRepository<Truong, UUID> {
    Optional<Truong> findByMaTruong(String maTruong);

    boolean existsByMaTruong(String maTruong);
}
