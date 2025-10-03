package com.university.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.university.dto.reponse.LichHocResponse;
import com.university.dto.request.DangKyLichHocRequest;
import com.university.entity.DangKyLichHoc;
import com.university.entity.LichHoc;
import com.university.entity.SinhVien;
import com.university.repository.DangKyLichHocRepository;
import com.university.repository.LichHocRepository;
import com.university.repository.SinhVienRepository;

@Service
public class DangKyLichHocService {

    private final DangKyLichHocRepository repository;
    private final SinhVienRepository sinhVienRepository;
    private final LichHocRepository lichHocRepository;

    public DangKyLichHocService(DangKyLichHocRepository repository,
            SinhVienRepository sinhVienRepository,
            LichHocRepository lichHocRepository) {
        this.repository = repository;
        this.sinhVienRepository = sinhVienRepository;
        this.lichHocRepository = lichHocRepository;
    }

    public void dangKy(DangKyLichHocRequest request) {
        SinhVien sv = sinhVienRepository.findById(request.getSinhVienId()).orElseThrow();
        LichHoc lh = lichHocRepository.findById(request.getLichHocId()).orElseThrow();

        if (repository.existsByLichHocAndSinhVien(lh, sv)) {
            throw new IllegalStateException("Đã đăng ký lịch học này");
        }

        DangKyLichHoc dk = new DangKyLichHoc();
        dk.setSinhVien(sv);
        dk.setLichHoc(lh);
        repository.save(dk);
    }

    public List<LichHocResponse> getLichHocBySinhVien(UUID sinhVienId) {
        return repository.findBySinhVienId(sinhVienId).stream().map(dk -> {
            LichHoc lh = dk.getLichHoc();
            LichHocResponse res = new LichHocResponse();
            res.setId(lh.getId());
            res.setTenMonHoc(lh.getMonHoc().getTenMonHoc());
            res.setTenPhong(lh.getPhongHoc().getTenPhong());
            res.setToaNha(lh.getPhongHoc().getToaNha());
            res.setTenKiHoc(lh.getKiHoc().getTenKiHoc());
            res.setNgayBatDau(lh.getNgayBatDau());
            res.setNgayKetThuc(lh.getNgayKetThuc());
            return res;
        }).collect(Collectors.toList());
    }
}
