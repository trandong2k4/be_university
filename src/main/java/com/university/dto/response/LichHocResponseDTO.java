package com.university.dto.response;

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
public class LichHocResponseDTO {
    private UUID id;
    private LocalDate ngayHoc;
    private String tenLop;
    private String tenGiangVien;
    private String tengioHoc;
    private String tenMonHoc;
    private String tenPhong;
    private String tenGioHoc;
    private int tang;
    private String toaNha;
    private String ghiChu;

    public interface LichHocViewDTO {
        String getMaLopHocPhan();

        String getTenMonHoc();

        String getTenGiangVien();

        String getTenPhong();

        String getToaNha();

        String getTenGioHoc();

        LocalDate getNgayHoc();

        LocalTime getGioBatDau();

        LocalTime getGioKetThuc();
    }

}