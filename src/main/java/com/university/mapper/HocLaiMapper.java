package com.university.mapper;

import org.springframework.stereotype.Component;
import com.university.dto.reponse.HocLaiResponseDTO;
import com.university.dto.request.HocLaiRequestDTO;
import com.university.entity.HocLai;
import com.university.entity.KiHoc;
import com.university.entity.MonHoc;
import com.university.entity.SinhVien;

@Component
public class HocLaiMapper {

    public HocLai toEntity(HocLaiRequestDTO dto, SinhVien sv, MonHoc monHoc, KiHoc kiHoc) {
        return HocLai.builder()
                .sinhVien(sv)
                .monHoc(monHoc)
                .kiHoc(kiHoc)
                .lanHoc(dto.getLanHoc())
                .diemCu(dto.getDiemCu())
                .trangThai(dto.getTrangThai())
                .lyDo(dto.getLyDo())
                // .ghiChu(dto.getGhiChu())
                // .ngayDangKy(LocalDate.now())
                .build();
    }

    public HocLaiResponseDTO toResponseDTO(HocLai hocLai) {
        return HocLaiResponseDTO.builder()
                .id(hocLai.getId())
                .tenSinhVien(hocLai.getSinhVien().getHoTen())
                .maSinhVien(hocLai.getSinhVien().getMaSinhVien())
                .tenMonHoc(hocLai.getMonHoc().getTenMonHoc())
                .tenKiHoc(hocLai.getKiHoc().getTenKiHoc())
                .lanHoc(hocLai.getLanHoc())
                .diemCu(hocLai.getDiemCu())
                .trangThai(hocLai.getTrangThai())
                .lyDo(hocLai.getLyDo())
                // .ghiChu(hocLai.getGhiChu())
                // .ngayDangKy(hocLai.getNgayDangKy())
                .build();
    }
}
