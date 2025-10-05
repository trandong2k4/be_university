package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;
import com.university.enums.ThuEnum;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuoiHocRequestDTO {

    @NotNull(message = "Ngày học không được để trống")
    private LocalDate ngayHoc;

    @NotNull(message = "Thứ trong tuần không được để trống")
    private ThuEnum thuTrongTuan;

    @NotNull(message = "Giờ học không được để trống")
    private UUID gioHocId;

    @NotNull(message = "Lịch học không được để trống")
    private UUID lichHocId;

    private String ghiChu;
}