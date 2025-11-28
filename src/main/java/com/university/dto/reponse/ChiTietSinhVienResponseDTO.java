package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.GioiTinhEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChiTietSinhVienResponseDTO {
    private UUID id;
    private String hoTen;
    private String maSinhVien;
    private LocalDate ngaySinh;
    private GioiTinhEnum gioiTinh;
    private String diaChi;
    private String quocTich;
    private String cccd;
    private String sdtNguoiThan;
}
