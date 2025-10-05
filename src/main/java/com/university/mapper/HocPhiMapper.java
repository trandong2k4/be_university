package com.university.mapper;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import com.university.dto.reponse.HocPhiResponseDTO;
import com.university.dto.request.HocPhiRequestDTO;
import com.university.entity.HocPhi;
import com.university.entity.KiHoc;
import com.university.entity.SinhVien;

@Component
public class HocPhiMapper {

    public HocPhi toEntity(HocPhiRequestDTO dto, SinhVien sv, KiHoc kiHoc) {
        return HocPhi.builder()
                .sinhVien(sv)
                .kiHoc(kiHoc)
                .soTien(dto.getSoTien())
                .giaTriTinChi(dto.getGiaTriTinChi())
                .hanThanhToan(dto.getHanThanhToan())
                .ngayThanhToan(dto.getNgayThanhToan())
                .ghiChu(dto.getGhiChu())
                .trangThai(dto.getTrangThai())
                .ngayTao(LocalDate.now())
                .build();
    }

    public HocPhiResponseDTO toResponseDTO(HocPhi hp) {
        return HocPhiResponseDTO.builder()
                .id(hp.getId())
                .tenSinhVien(hp.getSinhVien().getHoTen())
                .maSinhVien(hp.getSinhVien().getMaSinhVien())
                .tenKiHoc(hp.getKiHoc().getTenKiHoc())
                .soTien(hp.getSoTien())
                .giaTriTinChi(hp.getGiaTriTinChi())
                .hanThanhToan(hp.getHanThanhToan())
                .ngayThanhToan(hp.getNgayThanhToan())
                .trangThai(hp.getTrangThai())
                .ghiChu(hp.getGhiChu())
                .build();
    }
}