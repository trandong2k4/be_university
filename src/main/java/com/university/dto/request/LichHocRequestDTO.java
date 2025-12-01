package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LichHocRequestDTO {

    @NotNull(message = "Ngày học không được để trống")
    private LocalDate ngayHoc;

    @NotNull(message = "Giờ học không được để trống")
    private UUID gioHocId;

    @NotNull(message = "Lịch học không được để trống")
    private UUID lichHocId;

    private UUID lopHocPhanId;

    @NotNull(message = "Phòng học phần không được để trống")
    private UUID phongHocId;

    private String ghiChu;
}