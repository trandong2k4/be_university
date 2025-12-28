package com.university.mapper;

import org.springframework.stereotype.Component;
import com.university.dto.request.LopHocPhanRequestDTO;
import com.university.dto.response.LopHocPhanResponseDTO;
import com.university.entity.KiHoc;
import com.university.entity.LopHocPhan;
import com.university.entity.MonHoc;
import com.university.entity.NhanVien;

import lombok.RequiredArgsConstructor;

@Component // Bắt buộc phải có để Spring quản lý Mapper này
@RequiredArgsConstructor //
public class LopHocPhanMapper {

        public LopHocPhan toEntity(LopHocPhanRequestDTO dto, MonHoc monHoc, KiHoc kiHoc, NhanVien nhanVien) {

                return LopHocPhan.builder()
                                .maLopHocPhan(dto.getMaLopHocPhan())
                                .soLuongToiDa(dto.getSo_luong_toi_da())
                                .soLuongHienTai(dto.getSo_luong_hien_tai())
                                .trangThai(dto.getTrang_thai())
                                .monHoc(monHoc)
                                .kiHoc(kiHoc)
                                .nhanVien(nhanVien)
                                .build();
        }

        public LopHocPhanResponseDTO toResponseDTO(LopHocPhan dto) {
                LopHocPhanResponseDTO lopHocPhanResponseDTO = new LopHocPhanResponseDTO();
                lopHocPhanResponseDTO.setId(dto.getId());
                lopHocPhanResponseDTO.setMaLopHocPhan(dto.getMaLopHocPhan());
                lopHocPhanResponseDTO.setSoLuongToiDa(dto.getSoLuongToiDa());
                lopHocPhanResponseDTO.setSoLuongHienTai(dto.getSoLuongHienTai());
                lopHocPhanResponseDTO.setTrangThai(dto.getTrangThai());
                lopHocPhanResponseDTO.setMonHocId(dto.getMonHoc().getId());
                lopHocPhanResponseDTO.setTenMonHoc(dto.getMonHoc().getTenMonHoc());
                lopHocPhanResponseDTO.setTongSoTinChi(dto.getMonHoc().getTongSoTinChi());
                lopHocPhanResponseDTO.setGiangVienId(dto.getNhanVien().getId());
                lopHocPhanResponseDTO.setHoTen(dto.getNhanVien().getHoTen());
                lopHocPhanResponseDTO.setKiHocId(dto.getKiHoc().getId());
                lopHocPhanResponseDTO.setTenKiHoc(dto.getKiHoc().getTenKiHoc());
                return lopHocPhanResponseDTO;
        }
}
