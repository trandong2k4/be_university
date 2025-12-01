package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.LichHocResponseDTO;
import com.university.dto.request.LichHocRequestDTO;
import com.university.entity.GioHoc;
import com.university.entity.LichHoc;
import com.university.entity.LopHocPhan;
import com.university.entity.PhongHoc;
import com.university.exception.SimpleMessageException;
import com.university.repository.GioHocRepository;
import com.university.repository.LichHocRepository;
import com.university.repository.LopHocPhanRepository;
import com.university.repository.PhongHocRepository;

@Component
public class LichHocMapper {
        GioHocRepository gioHocRepository;
        PhongHocRepository phongHocRepository;
        LopHocPhanRepository lopHocPhanRepository;
        LichHocRepository lichHocRepository;

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

                return LichHocResponseDTO.builder()
                                .id(lichHoc.getId())
                                .ngayHoc(lichHoc.getNgayHoc())
                                .tenLop(lichHoc.getLopHocPhan().getMaLopHocPhan())
                                .tenGiangVien(lichHoc.getLopHocPhan().getGiangVien().getHoTen())
                                .tengioHoc(lichHoc.getGioHoc().getTenGioHoc())
                                .tenMonHoc(lichHoc.getLopHocPhan().getMonHoc().getTenMonHoc())
                                .tenPhong(lichHoc.getPhongHoc() != null ? lichHoc.getPhongHoc().getTenPhong() : null)
                                .tang(lichHoc.getPhongHoc() != null ? lichHoc.getPhongHoc().getTang() : 0)
                                .toaNha(lichHoc.getPhongHoc() != null ? lichHoc.getPhongHoc().getToaNha() : null)
                                .ghiChu(lichHoc.getGhiChu())
                                .build();
        }

}