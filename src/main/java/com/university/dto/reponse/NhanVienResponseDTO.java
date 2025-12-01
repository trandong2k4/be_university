package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienResponseDTO {
    private UUID id;
    private String hoTen;
    private String soDienThoai;
    private LocalDate ngayVaoLam;
    private LocalDate ngayNghiViec;
    private String tenViTri;
    private String tenNguoiDung;
}