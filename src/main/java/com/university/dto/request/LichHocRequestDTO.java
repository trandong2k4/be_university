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
public class LichHocRequestDTO {

    @NotNull(message = "Môn học không được để trống")
    private UUID monHocId;

    @NotNull(message = "Phòng học không được để trống")
    private UUID phongHocId;

    @NotNull(message = "Kỳ học không được để trống")
    private UUID kiHocId;

    @NotBlank(message = "Thứ học không được để trống")
    private String thu;

    @NotBlank(message = "Ca học không được để trống")
    private String caHoc;

    @NotNull(message = "Ngày bắt đầu không được để trống")
    private LocalDate ngayBatDau;

    @NotNull(message = "Ngày kết thúc không được để trống")
    private LocalDate ngayKetThuc;
}