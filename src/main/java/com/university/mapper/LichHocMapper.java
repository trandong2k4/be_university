package com.university.mapper;

import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import com.university.dto.request.LichHocRequestDTO;
import com.university.dto.response.LichHocResponseDTO;
import com.university.entity.GioHoc;
import com.university.entity.LichHoc;
import com.university.entity.LopHocPhan;
import com.university.entity.MonHoc;
import com.university.entity.NhanVien;
import com.university.entity.PhongHoc;
import com.university.exception.SimpleMessageException;
import com.university.repository.GioHocRepository;
import com.university.repository.LichHocRepository;
import com.university.repository.LopHocPhanRepository;
import com.university.repository.MonHocRepository;
import com.university.repository.NhanVienRepository;
import com.university.repository.PhongHocRepository;

@Component
public class LichHocMapper {
        GioHocRepository gioHocRepository;
        PhongHocRepository phongHocRepository;
        LopHocPhanRepository lopHocPhanRepository;
        LichHocRepository lichHocRepository;
        NhanVienRepository nhanVienRepository;
        MonHocRepository monHocRepository;

        public LichHoc toEntity(LichHocRequestDTO dto) {
                GioHoc gioHoc = gioHocRepository.findById(dto.getGioHocId())
                                .orElseThrow(() -> new SimpleMessageException("Không tìm thấy giờ học"));
                PhongHoc phongHoc = phongHocRepository.findById(dto.getPhongHocId())
                                .orElseThrow(() -> new SimpleMessageException("Không tìm thấy phòng học"));
                LopHocPhan lopHocPhan = lopHocPhanRepository.findById(dto.getLopHocPhanId())
                                .orElseThrow(() -> new SimpleMessageException("Không tìm thấy lớp học phần"));
                return LichHoc.builder()
                                .ngayHoc(dto.getNgayHoc())
                                .gioHoc(gioHoc)
                                .phongHoc(phongHoc)
                                .lopHocPhan(lopHocPhan)
                                .ghiChu(dto.getGhiChu())
                                .build();
        }

        public LichHocResponseDTO toResponseDTO(LichHoc lichHoc) {
                MonHoc monHoc = monHocRepository.findById(lichHoc.getLopHocPhan().getMonHoc().getId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy môn học"));

                NhanVien giangVien = nhanVienRepository.findById(lichHoc.getLopHocPhan().getNhanVien().getId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy giảng viên"));
                return LichHocResponseDTO.builder()
                                .id(lichHoc.getId())
                                .ngayHoc(lichHoc.getNgayHoc())
                                .tenLop(lichHoc.getLopHocPhan().getMaLopHocPhan())
                                .tenGiangVien(giangVien.getHoTen())
                                .tengioHoc(lichHoc.getGioHoc().getTenGioHoc())
                                .tenMonHoc(monHoc.getTenMonHoc())
                                .tenPhong(lichHoc.getPhongHoc() != null ? lichHoc.getPhongHoc().getTenPhong() : null)
                                .tang(lichHoc.getPhongHoc() != null ? lichHoc.getPhongHoc().getTang() : 0)
                                .toaNha(lichHoc.getPhongHoc() != null ? lichHoc.getPhongHoc().getToaNha() : null)
                                .ghiChu(lichHoc.getGhiChu())
                                .build();
        }

}