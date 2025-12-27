package com.university.mapper;

import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import com.university.dto.request.LopHocPhanRequestDTO;
import com.university.dto.response.LopHocPhanResponseDTO;
import com.university.entity.KiHoc;
import com.university.entity.LopHocPhan;
import com.university.entity.MonHoc;
import com.university.entity.NhanVien;
import com.university.repository.KiHocRepository;
import com.university.repository.MonHocRepository;
import com.university.repository.NhanVienRepository;

@Component
public class LopHocPhanMapper {
        private static MonHocRepository monHocRepository;
        private static KiHocRepository kiHocRepository;
        private static NhanVienRepository nhanVienRepository;

        public LopHocPhan toEntity(LopHocPhanRequestDTO dto) {
                MonHoc monHoc = monHocRepository.findById(dto.getMonHocId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy môn học"));

                KiHoc kiHoc = kiHocRepository.findById(dto.getKiHocId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy kì học"));

                NhanVien giangVien = nhanVienRepository.findById(dto.getGiangVienId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy giảng viên"));

                return LopHocPhan.builder()
                                .maLopHocPhan(dto.getMaLopHocPhan())
                                .soLuongToiDa(dto.getSo_luong_toi_da())
                                .soLuongHienTai(dto.getSo_luong_hien_tai())
                                .trangThai(dto.getTrang_thai())
                                .monHoc(monHoc)
                                .kiHoc(kiHoc)
                                .nhanVien(giangVien)
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
