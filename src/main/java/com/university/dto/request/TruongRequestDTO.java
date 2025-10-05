package com.university.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TruongRequestDTO {
    private String maTruong;
    private String tenTruong;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String website;
    private String moTa;
    private String logoUrl;
    private LocalDate ngayThanhLap;
    private String nguoiDaiDien;
}