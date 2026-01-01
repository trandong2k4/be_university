package com.university.service;

import com.university.dto.response.DangKyTinChiResponseDTO;
import com.university.entity.DangKyTinChi;
import com.university.entity.LichHoc;
import com.university.entity.LopHocPhan;
import com.university.entity.SinhVien;
import com.university.enums.TrangThaiLHP;
import com.university.exception.ResourceNotFoundException;
import com.university.exception.SimpleMessageException;
import com.university.repository.DangKyTinChiRepository;
import com.university.repository.LichHocRepository;
import com.university.repository.LopHocPhanRepository;
import com.university.repository.SinhVienRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DangKyTinChiService {

    private final DangKyTinChiRepository dkRepo;
    private final LopHocPhanRepository lhpRepo;
    private final SinhVienRepository svRepo;
    private final LichHocRepository lichHocRepo;

    // Lấy danh sách đăng ký theo lớp học phần
    public List<DangKyTinChi> getByLopHocPhan(UUID lopHocPhanId) {
        return dkRepo.findByLopHocPhanId(lopHocPhanId);
    }

    // Lấy danh sách lớp học phần mà sinh viên đã đăng ký
    public List<DangKyTinChi> getBySinhVien(UUID sinhVienId) {
        return dkRepo.findBySinhVienId(sinhVienId);
    }

    // Đăng ký tín chỉ - ĐÃ ĐƯỢC TỐI ƯU HOÀN TOÀN
    public DangKyTinChi DangKiTinChiSinhVien(UUID sinhVienId, UUID lopHocPhanId) {
        // 0. Kiểm tra null ngay lập tức để tránh lỗi JPA
        if (sinhVienId == null || lopHocPhanId == null) {
            throw new SimpleMessageException("Dữ liệu đăng ký không hợp lệ: ID sinh viên hoặc ID lớp học bị trống!");
        }

        SinhVien sinhVien = svRepo.findById(sinhVienId)
                .orElseThrow(() -> new SimpleMessageException("Sinh viên không tồn tại"));

        LopHocPhan lopMoi = lhpRepo.findById(lopHocPhanId)
                .orElseThrow(() -> new SimpleMessageException("Lớp học phần không tồn tại"));
        // 1. Kiểm tra đã đăng ký lớp này chưa
        if (dkRepo.findByLopHocPhanIdAndSinhVienId(sinhVienId, lopHocPhanId).isPresent()) {
            throw new SimpleMessageException("Bạn đã đăng ký lớp học phần này rồi!");
        }

        // 2. Kiểm tra lớp còn chỗ không
        if (lopMoi.getSoLuongHienTai() >= lopMoi.getSoLuongToiDa()) {
            throw new SimpleMessageException("Lớp học phần đã hết chỗ!");
        }

        // 3. Kiểm tra trạng thái lớp có mở đăng ký không
        if (lopMoi.getTrangThai() != TrangThaiLHP.MO_DANG_KY) {
            throw new SimpleMessageException("Lớp học phần hiện không mở đăng ký!");
        }

        // 4. Kiểm tra trùng lịch học (chỉ dùng gio_hoc_id + ngoại lệ CA5/CA6)
        List<LichHoc> lichHocMoi = lichHocRepo.findByLopHocPhanId(lopHocPhanId);
        List<DangKyTinChi> dsDaDangKy = dkRepo.findBySinhVienId(sinhVienId);

        for (DangKyTinChi dk : dsDaDangKy) {
            LopHocPhan lopDa = dk.getLopHocPhan();

            // Chỉ kiểm tra cùng kỳ học
            if (!lopDa.getKiHoc().getId().equals(lopMoi.getKiHoc().getId())) {
                continue;
            }

            List<LichHoc> lichHocCu = lichHocRepo.findByLopHocPhanId(lopDa.getId());

            for (LichHoc lhMoi : lichHocMoi) {
                for (LichHoc lhCu : lichHocCu) {
                    if (isTrungLich(lhMoi, lhCu)) {
                        throw new SimpleMessageException(
                                "Trùng lịch học vào " +
                                        lhMoi.getNgayHoc() + " - " +
                                        lhMoi.getGioHoc().getTenGioHoc() +
                                        " với lớp " + lopDa.getMaLopHocPhan());
                    }
                }
            }
        }

        // Nếu qua hết kiểm tra → đăng ký thành công
        DangKyTinChi dangKy = DangKyTinChi.builder()
                .sinhVien(sinhVien)
                .lopHocPhan(lopMoi)
                .build();

        DangKyTinChi saved = dkRepo.save(dangKy);

        // Tăng số lượng sinh viên hiện tại
        lopMoi.setSoLuongHienTai(lopMoi.getSoLuongHienTai() + 1);
        lhpRepo.save(lopMoi);
        return saved;
    }

    // Kiem tra trung lich
    private boolean isTrungLich(LichHoc lh1, LichHoc lh2) {
        if (!lh1.getNgayHoc().equals(lh2.getNgayHoc())) {
            return false;
        }

        UUID gio1 = lh1.getGioHoc().getId();
        UUID gio2 = lh2.getGioHoc().getId();

        // Cùng một ca → trùng hoàn toàn
        if (gio1.equals(gio2)) {
            return true;
        }

        return false;
    }

    public String unregister(UUID sinhVienId, UUID lopHocPhanId) {
        DangKyTinChi dk = dkRepo.findByLopHocPhanIdAndSinhVienId(
                lopHocPhanId, sinhVienId)
                .orElseThrow(() -> new SimpleMessageException("Bạn chưa đăng ký lớp học phần này"));

        LopHocPhan lop = dk.getLopHocPhan();

        // // Kiểm tra có được phép hủy không (ví dụ: trước ngày bắt đầu kỳ học)
        // if (LocalDate.now().isAfter(lop.getKiHoc().getNgayBatDau().minusDays(3))) {
        // throw new SimpleMessageException("Đã quá hạn hủy đăng ký!");
        // }

        dkRepo.delete(dk);

        // Giảm số lượng hiện tại
        if (lop.getSoLuongHienTai() > 0) {
            lop.setSoLuongHienTai(lop.getSoLuongHienTai() - 1);
            lhpRepo.save(lop);
        }

        return "Đã hủy đăng ký lớp học phần";
    }
}