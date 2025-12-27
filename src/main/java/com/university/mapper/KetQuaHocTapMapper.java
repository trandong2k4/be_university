package com.university.mapper;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import com.university.dto.request.KetQuaHocTapRequestDTO;
import com.university.dto.response.KetQuaHocTapResponseDTO;
import com.university.entity.DangKyTinChi;
import com.university.entity.KetQuaHocTap;
import com.university.entity.KiHoc;
import com.university.entity.LopHocPhan;
import com.university.entity.MonHoc;
import com.university.exception.SimpleMessageException;
import com.university.repository.DangKyTinChiRepository;
import com.university.repository.KiHocRepository;
import com.university.repository.LopHocPhanRepository;
import com.university.repository.MonHocRepository;
import com.university.repository.NhanVienRepository;

@Component
public class KetQuaHocTapMapper {

        DangKyTinChiRepository dangKyTinChiRepository;
        LopHocPhanRepository lopHocPhanRepository;
        MonHocRepository monHocRepository;
        KiHocRepository kiHocRepository;
        NhanVienRepository giangVienRepository;

        public KetQuaHocTap toEntity(KetQuaHocTapRequestDTO dto) {
                return KetQuaHocTap.builder()
                                .chuyenCan(dto.getChuyenCan())
                                .thuongKi(dto.getThuongKi())
                                .giuaKi(dto.getGiuaKi())
                                .cuoiKi(dto.getCuoiKi())
                                .danhGia(dto.getDanhGia())
                                .ghiChu(dto.getGhiChu())
                                .ngayCapNhat(LocalDate.now())
                                .build();
        }

        public KetQuaHocTapResponseDTO toResponseDTO(KetQuaHocTap kq) {
                DangKyTinChi dangKyTinChi = dangKyTinChiRepository
                                .findByLopHocPhanIdAndSinhVienId(kq.getDangKyTinChi().getLopHocPhan().getId(),
                                                kq.getDangKyTinChi().getSinhVien().getId())
                                .orElseThrow(() -> new SimpleMessageException("Sinh viên chưa dăng kí lớp này"));

                LopHocPhan lopHocPhan = lopHocPhanRepository.findById(dangKyTinChi.getLopHocPhan().getId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy môn học"));

                MonHoc monHoc = monHocRepository.findById(lopHocPhan.getMonHoc().getId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy môn học"));

                KiHoc kiHoc = kiHocRepository.findById(lopHocPhan.getKiHoc().getId())
                                .orElseThrow(() -> new ResourceAccessException("Không tìm thấy kì học"));
                return KetQuaHocTapResponseDTO.builder()
                                .id(kq.getId())
                                .tenSinhVien(dangKyTinChi.getSinhVien().getHoTen())
                                .tenMonHoc(monHoc.getTenMonHoc())
                                .tenKiHoc(kiHoc.getTenKiHoc())
                                .chuyenCan(kq.getChuyenCan())
                                .thuongKi(kq.getThuongKi())
                                .giuaKi(kq.getGiuaKi())
                                .cuoiKi(kq.getCuoiKi())
                                .danhGia(kq.getDanhGia())
                                .ghiChu(kq.getGhiChu())
                                .ngayCapNhat(kq.getNgayCapNhat())
                                .build();
        }
}