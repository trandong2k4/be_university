package com.university.dto.reponse;

import java.util.List;
import java.util.UUID;

import com.university.enums.TrangThaiLHP;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LopHocPhanResponseDTO {

    private UUID id;

    private String maLopHocPhan;

    private Integer soLuongToiDa;

    private Integer soLuongHienTai;

    private TrangThaiLHP trangThai;

    private MonHocDTO monHoc;

    private GiangVienDTO giangVien;

    private KiHocDTO kiHoc;

    private List<LichHocDTO> lichHocs;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MonHocDTO {
        private UUID id;
        private String tenMonHoc;
        private String maMonHoc;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class GiangVienDTO {
        private UUID id;
        private String hoTen;
        private String email;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class KiHocDTO {
        private UUID id;
        private String tenKiHoc;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class LichHocDTO {
        private UUID id;
        private String ngayHoc; // String hoặc LocalDate tùy bạn map
        private UUID phongHocId;
        private String ghiChu;
    }
}
