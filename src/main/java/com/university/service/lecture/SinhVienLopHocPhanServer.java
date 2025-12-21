package com.university.service.lecture;

import com.university.entity.DangKyTinChi;
import com.university.repository.DangKyTinChiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SinhVienLopHocPhanServer {

    private final DangKyTinChiRepository dangKyTinChiRepository;

    public Optional<DangKyTinChi> findByLophocphanIdAndSinhVien(UUID sinhVienId, UUID lopHocPhanId) {
        return dangKyTinChiRepository.findByLopHocPhanIdAndSinhVienId(lopHocPhanId, sinhVienId);
    }
}