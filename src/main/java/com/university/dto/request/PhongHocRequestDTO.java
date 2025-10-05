package com.university.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhongHocRequestDTO {

    @NotBlank(message = "Mã phòng học không được để trống")
    private String maPhong;

    @NotBlank(message = "Tên phòng không được để trống")
    private String tenPhong;

    private String toaNha;

    @Min(value = 0, message = "Tầng phải >= 0")
    private int tang;

    @Min(value = 1, message = "Sức chứa phải > 0")
    private int sucChua;
}