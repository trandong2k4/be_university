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

        @Query("SELECT d FROM LichHoc d WHERE d.lopHocPhan.id = :lopHocPhanId")
        List<LichHoc> findByLopHocPhanId(@Param("lopHocPhanId") UUID lopHocPhanId);

        @Query(value = "SELECT " +
                        "    lhp.ma_lop_hoc_phan, " +
                        "    mh.ten_mon_hoc, " +
                        "    gv.ho_ten AS ten_giang_vien, " +
                        "    ph.ten_phong, " +
                        "    ph.toa_nha, " +
                        "    lh.ngay_hoc, " +
                        "    gh.thoi_gian_bat_dau AS gio_bat_dau, " +
                        "    gh.thoi_gian_ket_thuc AS gio_ket_thuc " +
                        "FROM " +
                        "    public.lichhocs lh " +
                        "JOIN " +
                        "    public.lophocphans lhp ON lh.lop_hoc_phan_id = lhp.id " +
                        "JOIN " +
                        "    public.monhocs mh ON lhp.mon_hoc_id = mh.id " +
                        "JOIN " +
                        "    public.phonghocs ph ON lh.phong_hoc_id = ph.id " +
                        "JOIN " +
                        "    public.giohocs gh ON lh.gio_hoc_id = gh.id " +
                        "ORDER BY " +
                        "    lh.ngay_hoc, gh.thoi_gian_bat_dau", nativeQuery = true)
        List<Object[]> findFullLichHocDetailsNative();

        @Query(value = "SELECT " +
                        "    lhp.ma_lop_hoc_phan, " +
                        "    mh.ten_mon_hoc, " +
                        "    gv.ho_ten AS ten_giang_vien, " +
                        "    ph.ten_phong, " +
                        "    ph.toa_nha, " +
                        "    lh.ngay_hoc, " +
                        "    gh.thoi_gian_bat_dau AS gio_bat_dau, " +
                        "    gh.thoi_gian_ket_thuc AS gio_ket_thuc " +
                        "FROM " +
                        "    public.lichhocs lh " +
                        "JOIN " +
                        "    public.lophocphans lhp ON lh.lop_hoc_phan_id = lhp.id " +
                        "JOIN " +
                        "    public.dangky_tinchi dktc ON lhp.id = dktc.lop_hoc_phan_id " + // JOIN với bảng đăng ký
                        "JOIN " +
                        "    public.monhocs mh ON lhp.mon_hoc_id = mh.id " +
                        "JOIN " +
                        "    public.phonghocs ph ON lh.phong_hoc_id = ph.id " +
                        "JOIN " +
                        "    public.giohocs gh ON lh.gio_hoc_id = gh.id " +
                        "WHERE " +
                        "    dktc.sinh_vien_id = :sinhVienId " + // LỌC THEO sinh_vien_id
                        "ORDER BY " +
                        "    lh.ngay_hoc, gh.thoi_gian_bat_dau", nativeQuery = true)
        List<Object[]> findFullLichHocDetailsBySinhVienIdNative(@Param("sinhVienId") UUID sinhVienId);

}
