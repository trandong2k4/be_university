package com.university.repository;

import com.university.entity.Nganh;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NganhRepository extends JpaRepository<Nganh, UUID> {
    Page<Nganh> findByKhoaId(UUID khoaId, Pageable pageable);

    Optional<Nganh> findByMaNganh(String maNganh);

    @Query("SELECT n FROM Nganh n WHERE " +
            "(:tenNganh IS NULL OR LOWER(n.tenNganh) LIKE LOWER(CONCAT('%', :tenNganh, '%'))) AND " +
            "(:tenKhoa IS NULL OR LOWER(n.khoa.tenKhoa) = LOWER(:tenKhoa))")
    List<Nganh> search(@Param("tenNganh") String tenNganh,
            @Param("tenKhoa") String tenKhoa);

}
