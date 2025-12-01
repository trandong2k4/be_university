package com.university.dto.request;

import com.university.entity.GiangVien;
import com.university.entity.KiHoc;
import com.university.entity.LichHoc;
import com.university.entity.MonHoc;
import com.university.enums.TrangThaiLHP;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LopHocPhanRequestDTO {
    String maLopHocPhan;
    int so_luong_toi_da;
    int so_luong_hien_tai;
    TrangThaiLHP trang_thai;
    MonHoc monHoc;
    GiangVien giangVien;
    KiHoc kiHoc;
    LichHoc lichHoc;
}
