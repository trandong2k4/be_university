package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.ViTriEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienRequestDTO {

    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;

    @NotBlank(message = "Số điện thoại không được để trống")
    private String soDienThoai;

    private LocalDate ngayVaoLam;
    private LocalDate ngayNghiViec;
    private ViTriEnum viTri;

    @NotNull(message = "User ID không được để trống")
    private UUID userId;
}