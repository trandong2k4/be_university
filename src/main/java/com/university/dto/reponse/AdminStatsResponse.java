package com.university.dto.reponse;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminStatsResponse {
    private long sinhVienCount;
    private long sinhVienDangHoc;
    private long sinhVienTotNghiep;
    private long nganhCount;
    private long monHocCount;
    private long baiVietCount;
    private long userCount;
    private long giangVienCount;
    private Map<String, Long> sinhVienTheoNganh;
    private Map<Integer, Long> sinhVienTheoNamNhapHoc;
}
