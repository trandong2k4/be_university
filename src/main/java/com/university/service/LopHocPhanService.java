package com.university.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.university.dto.reponse.LopHocPhanResponseDTO;
import com.university.dto.request.LopHocPhanRequestDTO;
import com.university.entity.KiHoc;
import com.university.entity.LopHocPhan;
import com.university.entity.MonHoc;
import com.university.entity.NhanVien;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.LopHocPhanMapper;
import com.university.repository.KiHocRepository;
import com.university.repository.LopHocPhanRepository;
import com.university.repository.MonHocRepository;
import com.university.repository.NhanVienRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LopHocPhanService {

    private final LopHocPhanRepository lopHocPhanRepository;
    private final MonHocRepository monHocRepository;
    private final KiHocRepository kiHocRepository;
    private final NhanVienRepository nhanVienRepository;
    private final LopHocPhanMapper lopHocPhanMapper;

    public LopHocPhanResponseDTO create(LopHocPhanRequestDTO dto) {
        LopHocPhan lopHocPhan = lopHocPhanMapper.toEntity(dto);
        return lopHocPhanMapper.toResponseDTO(lopHocPhanRepository.save(lopHocPhan));
    }

    public List<LopHocPhanResponseDTO> getAll() {
        return lopHocPhanRepository.findAll().stream()
                .map(lopHocPhanMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public LopHocPhanResponseDTO getById(UUID id) {
        LopHocPhan lopHocPhan = lopHocPhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lớp học phần"));
        return lopHocPhanMapper.toResponseDTO(lopHocPhan);
    }

    public LopHocPhanResponseDTO update(UUID id, LopHocPhanRequestDTO dto) {

        LopHocPhan existing = lopHocPhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lớp học phần"));

        MonHoc monHoc = monHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy môn học"));

        KiHoc kiHoc = kiHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy kì học"));

        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân viên"));

        existing.setMaLopHocPhan(dto.getMaLopHocPhan());
        existing.setSoLuongHienTai(dto.getSo_luong_hien_tai());
        existing.setSoLuongToiDa(dto.getSo_luong_toi_da());
        existing.setTrangThai(dto.getTrang_thai());
        existing.setMonHoc(monHoc);
        existing.setNhanVien(nhanVien);
        existing.setKiHoc(kiHoc);
        return lopHocPhanMapper.toResponseDTO(lopHocPhanRepository.save(existing));
    }

    public void delete(UUID id) {
        lopHocPhanRepository.deleteById(id);
    }
}
