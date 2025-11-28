package com.university.dto.request;

import java.util.UUID;

import com.university.enums.TrangThaiLHP;


public class LopHocPhanRequestDTO {
    String maLopHocPhan;
    UUID kihoc_id;
    UUID monhoc_id;
    UUID giangvien_id;
    int so_luong_toi_da;
    int so_luong_hien_tai;
    TrangThaiLHP trang_thai;
}
