package com.university.repository;

import com.university.dto.response.LopHocPhanResponseDTO;
import com.university.entity.LopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, UUID> {

    @Query("""
            SELECT new com.university.dto.response.LopHocPhanResponseDTO(
                l.id,
                l.maLopHocPhan,
                l.soLuongToiDa,
                l.soLuongHienTai,
                l.trangThai,
                m.id,
                m.tenMonHoc,
                m.tongSoTinChi,
                nv.id,
                nv.hoTen,
                k.id,
                k.tenKiHoc
            )
            FROM LopHocPhan l
            JOIN l.monHoc m
            LEFT JOIN l.nhanVien nv
            JOIN l.kiHoc k
            """)
    List<LopHocPhanResponseDTO> findAllLopHocPhanResponse();
}
