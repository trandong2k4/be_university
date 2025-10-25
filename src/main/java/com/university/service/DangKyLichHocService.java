package com.university.service;

import com.university.entity.DangKyLichHoc;
import com.university.entity.LichHoc;
import com.university.entity.SinhVien;
import com.university.exception.ResourceNotFoundException;
import com.university.repository.DangKyLichHocRepository;
import com.university.repository.LichHocRepository;
import com.university.repository.SinhVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DangKyLichHocService {

    private final DangKyLichHocRepository dangKyLichHocRepository;
    private final LichHocRepository lichHocRepository;
    private final SinhVienRepository sinhVienRepository;

    // 🔹 Lấy tất cả lịch học mà sinh viên đã đăng ký
    public List<DangKyLichHoc> getBySinhVien(UUID sinhVienId) {
        return dangKyLichHocRepository.findBySinhVienId(sinhVienId);
    }

    // 🔹 Đăng ký lịch học mới
    public DangKyLichHoc register(UUID sinhVienId, UUID lichHocId) {
        SinhVien sinhVien = sinhVienRepository.findById(sinhVienId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên"));
        LichHoc lichHoc = lichHocRepository.findById(lichHocId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch học"));

        // Kiểm tra trùng
        if (dangKyLichHocRepository.findByLichHocAndSinhVien(lichHocId, sinhVienId).isPresent()) {
            throw new IllegalArgumentException("Sinh viên đã đăng ký lịch học này.");
        }

        DangKyLichHoc dk = DangKyLichHoc.builder()
                .lichHoc(lichHoc)
                .sinhVien(sinhVien)
                .build();

        return dangKyLichHocRepository.save(dk);
    }

    // 🔹 Hủy đăng ký
    public void unregister(UUID sinhVienId, UUID lichHocId) {
        DangKyLichHoc dk = dangKyLichHocRepository
                .findByLichHocAndSinhVien(lichHocId, sinhVienId)
                .orElseThrow(() -> new ResourceNotFoundException("Chưa đăng ký lịch học này"));
        dangKyLichHocRepository.delete(dk);
    }
}
