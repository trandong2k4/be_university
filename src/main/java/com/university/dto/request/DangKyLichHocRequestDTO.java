package com.university.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DangKyLichHocRequestDTO {

    @NotNull(message = "Lịch học không được để trống")
    private UUID lichHocId;

    @NotNull(message = "Sinh viên không được để trống")
    private UUID sinhVienId;
}