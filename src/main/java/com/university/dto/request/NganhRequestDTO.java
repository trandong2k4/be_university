package com.university.dto.request;

import com.university.entity.Khoa;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NganhRequestDTO {

    @NotBlank(message = "Mã ngành không được để trống")
    private String maNganh;

    @NotBlank(message = "Tên ngành không được để trống")
    private String tenNganh;

    private Khoa khoa;
}
