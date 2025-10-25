package com.university.repository;

import com.university.entity.LichHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface LichHocRepository extends JpaRepository<LichHoc, UUID> {

    @Query("SELECT l FROM LichHoc l WHERE LOWER(l.monHoc.tenMonHoc) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<LichHoc> searchByTenMonHoc(@Param("keyword") String keyword);

    // 🔹 Danh sách lịch học mà sinh viên đã đăng ký
    @Query("""
                SELECT lh FROM DangKyLichHoc dk
                JOIN dk.lichHoc lh
                WHERE dk.sinhVien.id = :sinhVienId
            """)
    List<LichHoc> findBySinhVienId(@Param("sinhVienId") UUID sinhVienId);
}
