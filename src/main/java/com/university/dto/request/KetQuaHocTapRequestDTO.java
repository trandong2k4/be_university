package com.university.dto.request;

import java.math.BigDecimal;
import java.util.UUID;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KetQuaHocTapRequestDTO {

    @NotNull(message = "Sinh viên không được để trống")
    private UUID sinhVienId;

    @NotNull(message = "Môn học không được để trống")
    private UUID monHocId;

    @NotNull(message = "Kỳ học không được để trống")
    private UUID kiHocId;

    @DecimalMin(value = "0.0", inclusive = true, message = "Điểm phải >= 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "Điểm phải <= 10")
    private BigDecimal diem;

    private String danhGia;
    private String ghiChu;
}