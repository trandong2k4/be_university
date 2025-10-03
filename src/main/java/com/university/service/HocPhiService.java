package com.university.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.university.dto.reponse.HocPhiResponse;
import com.university.dto.request.HocPhiRequest;
import com.university.entity.HocPhi;
import com.university.entity.SinhVien;
import com.university.entity.KiHoc;
import com.university.mapper.HocPhiMapper;
import com.university.repository.HocPhiRepository;
import com.university.repository.KiHocRepository;
import com.university.repository.SinhVienRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class HocPhiService {

    private final HocPhiRepository hocPhiRepository;
    private final SinhVienRepository sinhVienRepository;
    private final KiHocRepository kiHocRepository;
    private final HocPhiMapper hocPhiMapper;

    public HocPhiService(HocPhiRepository hocPhiRepository,
            SinhVienRepository sinhVienRepository,
            KiHocRepository kiHocRepository,
            HocPhiMapper hocPhiMapper) {
        this.hocPhiRepository = hocPhiRepository;
        this.sinhVienRepository = sinhVienRepository;
        this.kiHocRepository = kiHocRepository;
        this.hocPhiMapper = hocPhiMapper;
    }

    public HocPhiResponse create(HocPhiRequest request) {
        SinhVien sinhVien = sinhVienRepository.findById(request.getSinhVienId())
                .orElseThrow(() -> new EntityNotFoundException("Sinh viên không tồn tại"));
        KiHoc kiHoc = kiHocRepository.findById(request.getKiHocId())
                .orElseThrow(() -> new EntityNotFoundException("Kì học không tồn tại"));

        HocPhi hocPhi = hocPhiMapper.toEntity(request, sinhVien, kiHoc);
        hocPhi = hocPhiRepository.save(hocPhi);
        return hocPhiMapper.toResponse(hocPhi);
    }

    public HocPhiResponse update(UUID id, HocPhiRequest request) {
        HocPhi hocPhi = hocPhiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Học phí không tồn tại"));
        SinhVien sinhVien = sinhVienRepository.findById(request.getSinhVienId())
                .orElseThrow(() -> new EntityNotFoundException("Sinh viên không tồn tại"));
        KiHoc kiHoc = kiHocRepository.findById(request.getKiHocId())
                .orElseThrow(() -> new EntityNotFoundException("Kì học không tồn tại"));

        hocPhiMapper.updateEntity(hocPhi, request, sinhVien, kiHoc);
        hocPhi = hocPhiRepository.save(hocPhi);
        return hocPhiMapper.toResponse(hocPhi);
    }

    public HocPhiResponse getById(UUID id) {
        HocPhi hocPhi = hocPhiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Học phí không tồn tại"));
        return hocPhiMapper.toResponse(hocPhi);
    }

    public List<HocPhiResponse> getAll() {
        return hocPhiRepository.findAll().stream()
                .map(hocPhiMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(UUID id) {
        if (!hocPhiRepository.existsById(id)) {
            throw new EntityNotFoundException("Học phí không tồn tại");
        }
        hocPhiRepository.deleteById(id);
    }

    public List<HocPhiResponse> filterByTrangThai(String trangThai) {
        return hocPhiRepository.findByTrangThai(trangThai).stream()
                .map(hocPhiMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<HocPhiResponse> filterByKiHoc(UUID kiHocId) {
        return hocPhiRepository.findByKiHocId(kiHocId).stream()
                .map(hocPhiMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<HocPhiResponse> filterBySinhVien(UUID sinhVienId) {
        return hocPhiRepository.findBySinhVienId(sinhVienId).stream()
                .map(hocPhiMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<HocPhiResponse> filterTreHanChuaThanhToan(LocalDate beforeDate) {
        return hocPhiRepository.findByNgayThanhToanIsNullAndHanThanhToanBefore(beforeDate).stream()
                .map(hocPhiMapper::toResponse)
                .collect(Collectors.toList());
    }

}