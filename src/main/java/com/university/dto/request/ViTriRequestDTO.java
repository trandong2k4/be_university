package com.university.dto.request;

import java.math.BigDecimal;

import com.university.entity.GiangVien;
import com.university.entity.NhanVien;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ViTriRequestDTO {

    @NotBlank(message = "Mã vị trí không được để trống")
    private String maViTri;

    @NotBlank(message = "Tên vị trí không được để trống")
    private String tenViTri;

    private String moTa;

    @NotNull(message = "Mức lương cơ bản không được để trống")
    private BigDecimal mucLuongCoBan;

    private GiangVien giangVien;

    private NhanVien nhanVien;
}