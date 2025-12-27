package com.university.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.university.dto.response.LichHocStudentResponse;
import com.university.entity.LichHoc;

@Component
public class LichHocStudentMapper {

    public LichHoc toEntity(LichHoc lichHoc) {
        return lichHoc;
    }

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

    public LichHocStudentResponse toResponseDTO(LichHoc lichHoc) {
        LichHocStudentResponse dto = new LichHocStudentResponse();
        dto.setId(lichHoc.getId());
        dto.setNgayHoc(lichHoc.getNgayHoc());
        dto.setTenLop(lichHoc.getLopHocPhan().getMaLopHocPhan());
        dto.setTenMonHoc(lichHoc.getLopHocPhan().getMonHoc().getTenMonHoc());
        dto.setHoTen(lichHoc.getLopHocPhan().getNhanVien().getHoTen());
        dto.setThoiGianBatDau(thoiGianBatDau);
        dto.setThoiGianBatDau(dto.getThoiGianBatDau());
        dto.setThoiGianKetThuc(dto.getThoiGianKetThuc());
        dto.setTenPhong(lichHoc.getPhongHoc().getTenPhong());
        dto.setTang(lichHoc.getPhongHoc().getTang());
        dto.setToaNha(lichHoc.getPhongHoc().getToaNha());
        dto.setGhiChu(lichHoc.getGhiChu());
        return dto;
    }

}
