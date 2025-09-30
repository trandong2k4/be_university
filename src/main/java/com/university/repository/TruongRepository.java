package com.university.repository;

import com.university.entity.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TruongRepository extends JpaRepository<Truong, UUID> {
    boolean existsByMaTruong(String maTruong);
}
