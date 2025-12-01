package com.university.dto.reponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LichHocStudentReponse {
    private UUID id;
    private LocalDate ngayHoc;
    private String tenLop;
    private String tenMonHoc;
    private String tenGiangVien;
    private LocalDate gioBatDau;
    private LocalTime thoiGianBatDau;
    private LocalTime thoiGianKetThuc;
    private String tenPhong;
    private int tang;
    private String toaNha;
    private String ghiChu;
}
