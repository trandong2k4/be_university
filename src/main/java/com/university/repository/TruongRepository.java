package com.university.repository;

import com.university.entity.Truong;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TruongRepository extends JpaRepository<Truong, UUID> {

    // Tìm kiếm theo mã trường
    List<Truong> findByMaTruongContainingIgnoreCase(String maTruong);

    // Phân trang + lọc theo địa chỉ (tỉnh/thành)
    Page<Truong> findByDiaChiContainingIgnoreCase(String diaChi, org.springframework.data.domain.Pageable pageable);
}
