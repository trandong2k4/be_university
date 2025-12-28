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

        public LichHoc toEntity(LichHocRequestDTO dto, GioHoc gioHoc, PhongHoc phongHoc, LopHocPhan lopHocPhan) {
                return LichHoc.builder()
                                .ngayHoc(dto.getNgayHoc())
                                .gioHoc(gioHoc)
                                .phongHoc(phongHoc)
                                .lopHocPhan(lopHocPhan)
                                .ghiChu(dto.getGhiChu())
                                .build();
        }

        public LichHocResponseDTO toResponseDTO(LichHoc lh) {
                LopHocPhan lhp = lh.getLopHocPhan();

                return LichHocResponseDTO.builder()
                                .id(lh.getId())
                                .ngayHoc(lh.getNgayHoc())
                                .tenLop(lhp.getMaLopHocPhan())
                                .tenMonHoc(lhp.getMonHoc().getTenMonHoc())
                                .tenGiangVien(
                                                lhp.getNhanVien() != null
                                                                ? lhp.getNhanVien().getHoTen()
                                                                : null)
                                .tenGioHoc(lh.getGioHoc().getTenGioHoc())
                                .tenPhong(
                                                lh.getPhongHoc() != null
                                                                ? lh.getPhongHoc().getTenPhong()
                                                                : null)
                                .tang(
                                                lh.getPhongHoc() != null
                                                                ? lh.getPhongHoc().getTang()
                                                                : null)
                                .toaNha(
                                                lh.getPhongHoc() != null
                                                                ? lh.getPhongHoc().getToaNha()
                                                                : null)
                                .ghiChu(lh.getGhiChu())
                                .build();
        }

}