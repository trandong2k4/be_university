package com.university.repository;

import com.university.entity.KetQuaHocTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface KetQuaHocTapRepository extends JpaRepository<KetQuaHocTap, UUID> {

}