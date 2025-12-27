package com.university.dto.response;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AdminStatsResponseDTO {
    private long sinhVienCount;
    private long sinhVienDangHoc;
    private long sinhVienTotNghiep;
    private long nganhCount;
    private long khoaCount;
    private long truongCount;
    private long monHocCount;
    private long baiVietCount;
    private long userCount;
    private long giangVienCount;
    private Map<String, Long> sinhVienTheoNganh;
    private Map<Integer, Long> sinhVienTheoNamNhapHoc;
}
