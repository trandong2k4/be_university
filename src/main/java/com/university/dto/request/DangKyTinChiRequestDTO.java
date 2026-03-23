package com.university.dto.request;

import java.sql.Time;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DangKyTinChiRequestDTO {

    @NotNull(message = "Lịch học không được để trống")
    private UUID lophocphanId;

    @NotNull(message = "Sinh viên không được để trống")
    private UUID sinhVienId;

    private Time thoiGianDangKy;

    private String ghiChu;
}