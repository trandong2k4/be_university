package com.university.repository;

import com.university.entity.LopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, UUID> {
}
