package com.university.service;

import com.university.entity.DangKyTinChi;
import com.university.entity.LopHocPhan;
import com.university.entity.SinhVien;
import com.university.exception.ResourceNotFoundException;
import com.university.repository.DangKyTinChiRepository;
import com.university.repository.LopHocPhanRepository;
import com.university.repository.SinhVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DangKyTinChiService {

    private final DangKyTinChiRepository dangKyTinChiRepository;
    private final SinhVienRepository sinhVienRepository;
    private final LopHocPhanRepository dHocPhanRepository;

    // 🔹 Lấy tất cả danh sach mà sinh viên đã đăng ký
    public List<DangKyTinChi> getBySinhVien(UUID sinhVienId) {
        return dangKyTinChiRepository.findBySinhVienId(sinhVienId);
    }

    // 🔹 Đăng ký lịch học mới
    public DangKyTinChi register(UUID sinhVienId, UUID lophocphanId) {
        SinhVien sinhVien = sinhVienRepository.findById(sinhVienId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên"));
        LopHocPhan lophocphan = dHocPhanRepository.findById(lophocphanId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch học"));

        // Kiểm tra trùng
        if (dangKyTinChiRepository.findByLophocphanIdAndSinhVienId(lophocphanId, sinhVienId).isPresent()) {
            throw new IllegalArgumentException("Sinh viên đã đăng ký lịch học này.");
        }

        DangKyTinChi dk = DangKyTinChi.builder()
                .lophocphan(lophocphan)
                .sinhVien(sinhVien)
                .build();

        return dangKyTinChiRepository.save(dk);
    }

    // 🔹 Hủy đăng ký
    public void unregister(UUID sinhVienId, UUID lophocphanId) {
        DangKyTinChi dk = dangKyTinChiRepository
                .findByLophocphanIdAndSinhVienId(lophocphanId, sinhVienId)
                .orElseThrow(() -> new ResourceNotFoundException("Chưa đăng ký lịch học này"));
        dangKyTinChiRepository.delete(dk);
    }
}
