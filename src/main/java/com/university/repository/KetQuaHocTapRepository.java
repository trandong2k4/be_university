package com.university.repository;

import com.university.entity.KetQuaHocTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KetQuaHocTapRepository extends JpaRepository<KetQuaHocTap, UUID> {

    // Tìm kết quả theo sinh viên
    List<KetQuaHocTap> findBySinhVienId(UUID sinhVienId);

    // Tìm theo sinh viên và kỳ học
    List<KetQuaHocTap> findBySinhVienIdAndKiHocId(UUID sinhVienId, UUID kiHocId);

    // Kiểm tra đã có điểm cho môn học trong kỳ học
    boolean existsBySinhVienIdAndMonHocIdAndKiHocId(UUID sinhVienId, UUID monHocId, UUID kiHocId);

}