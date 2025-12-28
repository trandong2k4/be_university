package com.university.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LichHocSinhVienResponseDTO {

    private UUID lichHocId;

    private String maLopHocPhan;
    private String tenMonHoc;

    private LocalDate ngayHoc;

    private LocalTime gioBatDau;
    private LocalTime gioKetThuc;

    private String tenPhong;
    private String toaNha;

    private String tenGiangVien;
}
