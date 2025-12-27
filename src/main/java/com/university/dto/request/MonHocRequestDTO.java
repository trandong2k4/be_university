package com.university.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonHocRequestDTO {
    @NotBlank(message = "Mã môn học không được để trống")
    private String maMonHoc;

    @NotBlank(message = "Tên môn học không được để trống")
    private String tenMonHoc;

    private String moTa;

    @Min(1) // Assuming minimum 1 credit
    private int tongSoTinChi;
}