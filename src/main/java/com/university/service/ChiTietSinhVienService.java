package com.university.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.university.dto.reponse.ChiTietSinhVienResponseDTO;
import com.university.dto.reponse.TruongResponseDTO;
import com.university.dto.request.ChiTietSinhVienRequestDTO;
import com.university.entity.ChiTietSinhVien;
import com.university.entity.SinhVien;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.ChiTietSinhVienMapper;
import com.university.repository.ChiTietSinhVienRepository;
import com.university.repository.SinhVienRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChiTietSinhVienService {

    private final ChiTietSinhVienRepository chiTietSinhVienRepository;
    private final SinhVienRepository sinhVienRepository;
    private final ChiTietSinhVienMapper chiTietSinhVienMapper;

    public ChiTietSinhVienResponseDTO create(ChiTietSinhVienRequestDTO dto) {
        SinhVien sv = sinhVienRepository.findById(dto.getSinhVienId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên"));

        ChiTietSinhVien ct = chiTietSinhVienMapper.toEntity(dto, sv);
        return chiTietSinhVienMapper.toResponseDTO(chiTietSinhVienRepository.save(ct));
    }

    public List<ChiTietSinhVienResponseDTO> getAll() {
        return chiTietSinhVienRepository.findAll().stream()
                .map(chiTietSinhVienMapper::toResponseDTO)
                .toList();
    }

    public ChiTietSinhVienResponseDTO getById(UUID id) {
        ChiTietSinhVien ct = chiTietSinhVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy chi tiết sinh viên"));
        return chiTietSinhVienMapper.toResponseDTO(ct);
    }

    public List<ChiTietSinhVienResponseDTO> search(String keyword) {
        return chiTietSinhVienRepository.searchByTenSinhVien(keyword).stream()
                .map(chiTietSinhVienMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ChiTietSinhVienResponseDTO update(UUID id, ChiTietSinhVienRequestDTO dto) {
        ChiTietSinhVien existing = chiTietSinhVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy chi tiết sinh viên"));

        existing.setDiaChi(dto.getDiaChi());
        existing.setNgaySinh(dto.getNgaySinh());
        existing.setGioiTinh(dto.getGioiTinh());
        existing.setQuocTich(dto.getQuocTich());
        existing.setCccd(dto.getCccd());
        existing.setSdtNguoiThan(dto.getSdtNguoiThan());

        return chiTietSinhVienMapper.toResponseDTO(chiTietSinhVienRepository.save(existing));
    }

    public void delete(UUID id) {
        chiTietSinhVienRepository.deleteById(id);
    }
}