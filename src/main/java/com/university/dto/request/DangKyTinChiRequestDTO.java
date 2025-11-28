package com.university.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DangKyTinChiRequestDTO {

    @NotNull(message = "Lịch học không được để trống")
    private UUID lophocphanId;

    @NotNull(message = "Sinh viên không được để trống")
    private UUID sinhVienId;
}