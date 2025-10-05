package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienResponseDTO {
    private UUID id;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private LocalDate ngayVaoLam;
    private LocalDate ngayNghiViec;
    private String tenViTri;
    private String tenNguoiDung;
}