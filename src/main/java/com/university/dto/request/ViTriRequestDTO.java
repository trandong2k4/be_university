package com.university.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViTriRequestDTO {

    @NotBlank(message = "Mã vị trí không được để trống")
    private String maViTri;

    @NotBlank(message = "Tên vị trí không được để trống")
    private String tenViTri;

    private String moTa;

    @NotNull(message = "Mức lương cơ bản không được để trống")
    private BigDecimal mucLuongCoBan;
}