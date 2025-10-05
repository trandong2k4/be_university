package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.GioiTinhEnum;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSinhVienRequestDTO {

    private String diaChi;
    private LocalDate ngaySinh;
    private GioiTinhEnum gioiTinh;
    private String quocTich;
    private String cccd;
    private String sdtNguoiThan;

    @NotNull(message = "Sinh viên không được để trống")
    private UUID sinhVienId;
}
