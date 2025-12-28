package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.ViTriEnum;

import jakarta.validation.constraints.NotBlank;
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

    private UUID userId;
}