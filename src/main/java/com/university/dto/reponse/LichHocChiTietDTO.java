package com.university.dto.reponse;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LichHocChiTietDTO {
    private String maLopHocPhan;
    private String tenMonHoc;
    private String tenGiangVien;
    private String tenPhong;
    private String toaNha;
    private LocalDate ngayHoc;
    private LocalTime gioBatDau;
    private LocalTime gioKetThuc;
}
