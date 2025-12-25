package com.university.controller;

import com.university.dto.reponse.AdminStatsResponse;
import com.university.dto.reponse.WeeklyStatDTO;
import com.university.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminStatsController {

    private final SinhVienRepository sinhVienRepository;
    private final NganhRepository nganhRepository;
    private final MonHocRepository monHocRepository;
    private final BaiVietRepository baiVietRepository;
    private final UserRepository userRepository;
    private final NhanVienRepository nhanVienRepository;
    private final KhoaRepository khoaRepository;
    private final TruongRepository truongRepository;

    @GetMapping("/stats")
    public AdminStatsResponse getStats() {
        long sinhVienCount = sinhVienRepository.count();
        long sinhVienDangHoc = sinhVienRepository.countByNgayTotNghiepIsNull();
        long sinhVienTotNghiep = sinhVienRepository.countByNgayTotNghiepIsNotNull();
        long nganhCount = nganhRepository.count();
        long khoaCount = khoaRepository.count();
        long truongCount = truongRepository.count();
        long monHocCount = monHocRepository.count();
        long baiVietCount = baiVietRepository.count();
        long userCount = userRepository.count();
        long giangVienCount = nhanVienRepository.count();
        // ======== Sửa tại đây =========
        List<Object[]> rawNganh = sinhVienRepository.countByNganhRaw();
        Map<String, Long> sinhVienTheoNganh = new LinkedHashMap<>();
        for (Object[] row : rawNganh) {
            sinhVienTheoNganh.put(
                    (String) row[0], // tên ngành
                    ((Number) row[1]).longValue() // số lượng
            );
        }

        List<Object[]> rawNam = sinhVienRepository.countByNamNhapHocRaw();
        Map<Integer, Long> sinhVienTheoNamNhapHoc = new LinkedHashMap<>();
        for (Object[] row : rawNam) {
            sinhVienTheoNamNhapHoc.put(
                    ((Number) row[0]).intValue(), // năm nhập học
                    ((Number) row[1]).longValue() // số lượng
            );
        }

        return new AdminStatsResponse(
                sinhVienCount,
                sinhVienDangHoc,
                sinhVienTotNghiep,
                nganhCount,
                khoaCount,
                truongCount,
                monHocCount,
                baiVietCount,
                userCount,
                giangVienCount,
                sinhVienTheoNganh,
                sinhVienTheoNamNhapHoc);
    }

    @GetMapping("/stats/weekly")
    public WeeklyStatDTO getWeeklyStats() {
        List<String> labels = new ArrayList<>();
        List<Long> values = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            labels.add("Tuần " + i);
            values.add((long) sinhVienRepository.countByNgayTotNghiepIsNull()
                    - sinhVienRepository.countByNgayTotNghiepIsNotNull());
        }

        return new WeeklyStatDTO(labels, values);
    }
}
