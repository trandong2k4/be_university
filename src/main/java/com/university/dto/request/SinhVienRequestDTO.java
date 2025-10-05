package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinhVienRequestDTO {
    private String maSinhVien;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private LocalDate ngayNhapHoc;
    private LocalDate ngayTotNghiep;
    private UUID nganhId;
    private UUID userId;
}
