package com.university.dto.response;

import java.sql.Time;
import java.util.UUID;

import com.university.enums.ViTriEnum;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NhanVienResponseDTO {

    private UUID id;

    private String maNhanVien;

    private String hoTen;

    private String soDienThoai;

    private Time ngayVaoLam;

    private Time ngayNghiViec;

    private ViTriEnum ViTri;

    private UUID userId;

    private String tenNguoiDung;

    public interface NhanVienView {
        UUID getId();

        String getUsername();
    }

}