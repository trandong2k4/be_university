package com.university.controller;

import com.university.dto.reponse.AdminStatsResponse;
import com.university.dto.reponse.WeeklyStatDTO;
import com.university.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminStatsController {

    private final SinhVienRepository sinhVienRepository;
    private final NganhRepository nganhRepository;
    private final MonHocRepository monHocRepository;
    private final BaiVietRepository baiVietRepository;
    private final UserRepository userRepository;

    @GetMapping("/stats")
    public AdminStatsResponse getStats() {
        long sinhVienCount = sinhVienRepository.count();
        long sinhVienDangHoc = sinhVienRepository.countByNgayTotNghiepIsNull();
        long sinhVienTotNghiep = sinhVienRepository.countByNgayTotNghiepIsNotNull();
        long nganhCount = nganhRepository.count();
        long monHocCount = monHocRepository.count();
        long baiVietCount = baiVietRepository.count();
        long userCount = userRepository.count();

        Map<String, Long> sinhVienTheoNganh = sinhVienRepository.countByNganh();
        Map<Integer, Long> sinhVienTheoNamNhapHoc = sinhVienRepository.countByNamNhapHoc();

        // Nếu chưa có giảng viên riêng thì set tạm = 0
        long giangVienCount = 0L;

        return new AdminStatsResponse(
                sinhVienCount,
                sinhVienDangHoc,
                sinhVienTotNghiep,
                nganhCount,
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
            values.add((long) (Math.random() * 50 + 10));
        }

        return new WeeklyStatDTO(labels, values);
    }
}
