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
    @NotBlank
    private String maMonHoc;

    @NotBlank
    private String tenMonHoc;

    private String moTa;

    @Min(0)
    private int tongSoTinChi;
}