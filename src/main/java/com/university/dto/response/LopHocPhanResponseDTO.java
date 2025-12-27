package com.university.dto.response;

import java.util.UUID;
import com.university.enums.TrangThaiLHP;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LopHocPhanResponseDTO {
    private UUID id;
    private String maLopHocPhan;
    private Integer soLuongToiDa;
    private Integer soLuongHienTai;
    private TrangThaiLHP trangThai;

    private UUID monHocId;
    private String tenMonHoc;
    private Integer tongSoTinChi;

    private UUID giangVienId;
    private String hoTen;

    private UUID kiHocId;
    private String tenKiHoc;

    public LopHocPhanResponseDTO(
            UUID id,
            String maLopHocPhan,
            Integer soLuongToiDa,
            Integer soLuongHienTai,
            TrangThaiLHP trangThai,
            UUID monHocId,
            String tenMonHoc,
            Integer tongSoTinChi,
            UUID giangVienId,
            String hoTen,
            UUID kiHocId,
            String tenKiHoc) {
        this.id = id;
        this.maLopHocPhan = maLopHocPhan;
        this.soLuongToiDa = soLuongToiDa;
        this.soLuongHienTai = soLuongHienTai;
        this.trangThai = trangThai;
        this.monHocId = monHocId;
        this.tenMonHoc = tenMonHoc;
        this.tongSoTinChi = tongSoTinChi;
        this.giangVienId = giangVienId;
        this.hoTen = hoTen;
        this.kiHocId = kiHocId;
        this.tenKiHoc = tenKiHoc;
    }
}
