package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienRequestDTO {

    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;

    @NotBlank(message = "Số điện thoại không được để trống")
    private String soDienThoai;

    private LocalDate ngayVaoLam;
    private LocalDate ngayNghiViec;

    @NotNull(message = "Vị trí không được để trống")
    private UUID viTriId;

    @NotNull(message = "User ID không được để trống")
    private UUID userId;
}