package com.university.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.university.dto.reponse.HocPhiResponseDTO;
import com.university.dto.reponse.TruongResponseDTO;
import com.university.dto.request.HocPhiRequestDTO;
import com.university.entity.HocPhi;
import com.university.entity.SinhVien;
import com.university.exception.ResourceNotFoundException;
import com.university.entity.KiHoc;
import com.university.mapper.HocPhiMapper;
import com.university.repository.HocPhiRepository;
import com.university.repository.KiHocRepository;
import com.university.repository.SinhVienRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HocPhiService {

    private final HocPhiRepository hocPhiRepository;
    private final SinhVienRepository sinhVienRepository;
    private final KiHocRepository kiHocRepository;
    private final HocPhiMapper hocPhiMapper;

    public HocPhiResponseDTO create(HocPhiRequestDTO dto) {
        SinhVien sv = sinhVienRepository.findById(dto.getSinhVienId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên"));
        KiHoc kiHoc = kiHocRepository.findById(dto.getKiHocId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy kỳ học"));

        HocPhi hp = hocPhiMapper.toEntity(dto, sv, kiHoc);
        return hocPhiMapper.toResponseDTO(hocPhiRepository.save(hp));
    }

    public List<HocPhiResponseDTO> getAll() {
        return hocPhiRepository.findAll().stream()
                .map(hocPhiMapper::toResponseDTO)
                .toList();
    }

    public HocPhiResponseDTO getById(UUID id) {
        HocPhi hp = hocPhiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy học phí"));
        return hocPhiMapper.toResponseDTO(hp);
    }

    public List<HocPhiResponseDTO> search(String keyword) {
        return hocPhiRepository.searchByTenSinhVien(keyword).stream()
                .map(hocPhiMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public HocPhiResponseDTO update(UUID id, HocPhiRequestDTO dto) {
        HocPhi existing = hocPhiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy học phí"));

        existing.setSoTien(dto.getSoTien());
        existing.setGiaTriTinChi(dto.getGiaTriTinChi());
        existing.setHanThanhToan(dto.getHanThanhToan());
        existing.setNgayThanhToan(dto.getNgayThanhToan());
        existing.setTrangThai(dto.getTrangThai());
        existing.setGhiChu(dto.getGhiChu());

        return hocPhiMapper.toResponseDTO(hocPhiRepository.save(existing));
    }

    public void delete(UUID id) {
        hocPhiRepository.deleteById(id);
    }
}