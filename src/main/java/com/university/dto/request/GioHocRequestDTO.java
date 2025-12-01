package com.university.dto.request;

import java.time.LocalTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHocRequestDTO {

    @NotBlank(message = "Tên giờ học không được để trống")
    private String maGioHoc;

    @NotBlank(message = "Ca học không được để trống")
    private String tenGioHoc;

    @NotNull(message = "Thời gian bắt đầu không được để trống")
    private LocalTime thoiGianBatDau;

    @NotNull(message = "Thời gian kết thúc không được để trống")
    private LocalTime thoiGianKetThuc;
}