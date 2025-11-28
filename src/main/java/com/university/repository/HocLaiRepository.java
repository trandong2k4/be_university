// package com.university.repository;

// import java.util.List;
// import java.util.UUID;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;

// import com.university.entity.HocLai;

// @Repository
// public interface HocLaiRepository extends JpaRepository<HocLai, UUID> {

// @Query("SELECT h FROM HocLai h WHERE LOWER(h.sinhVien.hoTen) LIKE
// LOWER(CONCAT('%', :keyword, '%'))")
// List<HocLai> searchByTenSinhVien(@Param("keyword") String keyword);

// List<HocLai> findBySinhVienId(UUID sinhVienId);
// }
