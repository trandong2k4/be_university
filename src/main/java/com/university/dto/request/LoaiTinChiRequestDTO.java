package com.university.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiTinChiRequestDTO {

    @NotBlank(message = "Mã loại tín chỉ không được để trống")
    private String maLoaiTinChi;

    @NotBlank(message = "Tên loại tín chỉ không được để trống")
    private String tenLoaiTinChi;
}