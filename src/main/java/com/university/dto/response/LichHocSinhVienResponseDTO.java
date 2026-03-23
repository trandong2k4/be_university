package com.university.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LichHocSinhVienResponseDTO {

    private UUID id;

    private String maLopHocPhan;

    private String tenMonHoc;

    private LocalDate ngayHoc;

    private LocalTime thoiGianBatDau;

    private LocalTime thoiGianKetThuc;

    private String tenPhong;

    private String toaNha;

    private String hoTen;
}
