package com.university.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LichHocStudentResponse {
    private UUID id;
    private LocalDate ngayHoc;
    private String tenLop;
    private String tenMonHoc;
    private String hoTen;
    private LocalTime thoiGianBatDau;
    private LocalTime thoiGianKetThuc;
    private String tenPhong;
    private int tang;
    private String toaNha;
    private String ghiChu;

    public LichHocStudentResponse(UUID id, LocalDate ngayHoc, String tenLop, String tenMonHoc, String hoTen,
            LocalTime thoiGianBatDau, LocalTime thoiGianKetThuc, String tenPhong, int tang, String toaNha,
            String ghiChu) {
        this.id = id;
        this.ngayHoc = ngayHoc;
        this.tenLop = tenLop;
        this.tenMonHoc = tenMonHoc;
        this.hoTen = hoTen;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.tenPhong = tenPhong;
        this.tang = tang;
        this.toaNha = toaNha;
        this.ghiChu = ghiChu;
    }
}
