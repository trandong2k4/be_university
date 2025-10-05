package com.university.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhoaRequestDTO {
    @NotBlank(message = "Mã khoa không được để trống")
    private String maKhoa;

    @NotBlank(message = "Tên khoa không được để trống")
    private String tenKhoa;

    @NotNull(message = "Trường không được để trống")
    private UUID truongId;
}