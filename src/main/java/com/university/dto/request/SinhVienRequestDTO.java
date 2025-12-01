package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVienRequestDTO {
    private String maSinhVien;
    private String hoTen;
    private String soDienThoai;
    private LocalDate ngayNhapHoc;
    private LocalDate ngayTotNghiep;
    private UUID nganhId;
    private UUID userId;
}
