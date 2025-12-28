package com.university.repository;

import com.university.dto.response.LichHocResponseDTO.LichHocViewDTO;
import com.university.dto.response.LichHocSinhVienResponseDTO;
import com.university.entity.LichHoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface LichHocRepository extends JpaRepository<LichHoc, UUID> {

    @Query("SELECT d FROM LichHoc d WHERE d.lopHocPhan.id = :lopHocPhanId")
    List<LichHoc> findByLopHocPhanId(@Param("lopHocPhanId") UUID lopHocPhanId);

    @Query(value = """
                SELECT
                    lhp.ma_lop_hoc_phan AS maLopHocPhan,
                    mh.ten_mon_hoc AS tenMonHoc,
                    nv.ho_ten AS tenNhanVien,
                    ph.ten_phong AS tenPhong,
                    ph.toa_nha AS toaNha,
                    lh.ngay_hoc AS ngayHoc,
                    gh.thoi_gian_bat_dau AS gioBatDau,
                    gh.thoi_gian_ket_thuc AS gioKetThuc
                FROM lichhocs lh
                JOIN lophocphans lhp ON lh.lop_hoc_phan_id = lhp.id
                JOIN monhocs mh ON lhp.mon_hoc_id = mh.id
                LEFT JOIN nhanviens nv ON lhp.nhan_vien_id = nv.id
                JOIN phonghocs ph ON lh.phong_hoc_id = ph.id
                JOIN giohocs gh ON lh.gio_hoc_id = gh.id
                ORDER BY lh.ngay_hoc, gh.thoi_gian_bat_dau
            """, nativeQuery = true)
    List<LichHocViewDTO> findFullSchedule();

    @Query("""
                SELECT new com.university.dto.response.LichHocSinhVienResponseDTO(
                    lh.id,
                    lhp.maLopHocPhan,
                    mh.tenMonHoc,
                    lh.ngayHoc,
                    gh.thoiGianBatDau,
                    gh.thoiGianKetThuc,
                    ph.tenPhong,
                    ph.toaNha,
                    nv.hoTen
                )
                FROM LichHoc lh
                JOIN lh.lopHocPhan lhp
                JOIN lhp.monHoc mh
                LEFT JOIN lhp.nhanVien nv
                JOIN lh.gioHoc gh
                JOIN lh.phongHoc ph
                JOIN DangKyTinChi dktc ON dktc.lopHocPhan.id = lhp.id
                WHERE dktc.sinhVien.id = :sinhVienId
                ORDER BY lh.ngayHoc, gh.thoiGianBatDau
            """)
    List<LichHocSinhVienResponseDTO> findScheduleBySinhVien(
            @Param("sinhVienId") UUID sinhVienId);

}
