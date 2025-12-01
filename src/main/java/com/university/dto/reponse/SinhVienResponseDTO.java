package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SinhVienResponseDTO {
    private UUID id;
    private String maSinhVien;
    private String hoTen;
    private String email;
    private LocalDate ngaynhapHoc;
    private String soDienThoai;
    private String tenNganh;
    private String tenKhoa;
    private String tenTruong;
}