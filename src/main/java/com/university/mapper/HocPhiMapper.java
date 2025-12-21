package com.university.mapper;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import com.university.dto.reponse.HocPhiResponseDTO;
import com.university.dto.request.HocPhiRequestDTO;
import com.university.entity.HocPhi;
import com.university.entity.SinhVien;

@Component
public class HocPhiMapper {

    public HocPhi toEntity(HocPhiRequestDTO dto, SinhVien sv) {
        return HocPhi.builder()
                .soTien(dto.getSoTien())
                .ngayTao(LocalDate.now())
                .hanThanhToan(dto.getHanThanhToan())
                .ngayThanhToan(dto.getNgayThanhToan())
                .ghiChu(dto.getGhiChu())
                .trangThai(dto.getTrangThai())
                .sinhVien(sv)
                .build();
    }

    public HocPhiResponseDTO toResponseDTO(HocPhi hp) {
        return HocPhiResponseDTO.builder()
                .id(hp.getId())
                .tenSinhVien(hp.getSinhVien().getHoTen())
                .maSinhVien(hp.getSinhVien().getMaSinhVien())
                .soTien(hp.getSoTien())
                .hanThanhToan(hp.getHanThanhToan())
                .ngayThanhToan(hp.getNgayThanhToan())
                .trangThai(hp.getTrangThai())
                .ghiChu(hp.getGhiChu())
                .build();
    }

}