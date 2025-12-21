package com.university.mapper;

import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import com.university.dto.reponse.LopHocPhanResponseDTO;
import com.university.dto.request.LopHocPhanRequestDTO;
import com.university.entity.KiHoc;
import com.university.entity.LopHocPhan;
import com.university.entity.MonHoc;
import com.university.entity.NhanVien;
import com.university.repository.KiHocRepository;
import com.university.repository.MonHocRepository;
import com.university.repository.NhanVienRepository;

@Component
public class LopHocPhanMapper {

        private final MonHocRepository monHocRepository;
        private final KiHocRepository kiHocRepository;
        private final NhanVienRepository nhanVienRepository;

        public LopHocPhanMapper(
                        MonHocRepository monHocRepository,
                        KiHocRepository kiHocRepository,
                        NhanVienRepository nhanVienRepository) {
                this.monHocRepository = monHocRepository;
                this.kiHocRepository = kiHocRepository;
                this.nhanVienRepository = nhanVienRepository;
        }

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
                MonHoc monHoc = monHocRepository.findById(dto.getMonHoc().getId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy môn học"));

                KiHoc kiHoc = kiHocRepository.findById(dto.getKiHoc().getId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy kì học"));

                NhanVien nhanVien = nhanVienRepository.findById(dto.getNhanVien().getId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy giảng viên"));

                return LopHocPhanResponseDTO.builder()
                                .id(dto.getId())
                                .maLopHocPhan(dto.getMaLopHocPhan())
                                .soLuongToiDa(dto.getSoLuongToiDa())
                                .soLuongHienTai(dto.getSoLuongHienTai())
                                .soTinCHi(monHoc.getTongSoTinChi())
                                .trangThai(dto.getTrangThai())
                                .monHocId(monHoc.getId())
                                .tenMonHoc(monHoc.getTenMonHoc())
                                .kiHocId(kiHoc.getId())
                                .tenKiHoc(kiHoc.getTenKiHoc())
                                .giangVienId(nhanVien.getId())
                                .tenGiangVien(nhanVien.getHoTen())
                                .build();
        }
}
