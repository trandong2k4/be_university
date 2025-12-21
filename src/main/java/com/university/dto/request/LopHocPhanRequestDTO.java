package com.university.dto.request;

import java.util.UUID;
import com.university.enums.TrangThaiLHP;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LopHocPhanRequestDTO {
    private String maLopHocPhan;
    private Integer so_luong_toi_da;
    private Integer so_luong_hien_tai;
    private TrangThaiLHP trang_thai;
    private UUID monHocId;
    private UUID giangVienId;
    private UUID kiHocId;
}
