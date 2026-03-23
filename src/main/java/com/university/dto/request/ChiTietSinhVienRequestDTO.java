package com.university.dto.request;

import java.sql.Time;
import java.util.UUID;

import com.university.enums.GioiTinhEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChiTietSinhVienRequestDTO {

    private String diaChi;

    private Time ngaySinh;

    private GioiTinhEnum gioiTinh;

    private String quocTich;

    private String cccd;

    private String sdtNguoiThan;

    @NotNull(message = "Sinh viên không được để trống")
    private UUID sinhVienId;
}
