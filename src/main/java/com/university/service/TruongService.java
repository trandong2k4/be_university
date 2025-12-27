package com.university.service;

import com.university.dto.request.TruongRequestDTO;
import com.university.dto.response.TruongResponseDTO;
import com.university.entity.Truong;
import com.university.repository.TruongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TruongService {

    private final TruongRepository truongRepository;

    public List<TruongResponseDTO> getAll() {
        return truongRepository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public TruongResponseDTO getById(UUID id) {
        Truong truong = truongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy trường"));
        return toResponseDTO(truong);
    }

    public TruongResponseDTO create(TruongRequestDTO dto) {
        if (truongRepository.existsByMaTruong(dto.getMaTruong())) {
            throw new RuntimeException("Mã trường đã tồn tại");
        }

        Truong truong = new Truong();
        updateEntity(truong, dto);
        truongRepository.save(truong);
        return toResponseDTO(truong);
    }

    public TruongResponseDTO update(UUID id, TruongRequestDTO dto) {
        Truong truong = truongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy trường"));
        updateEntity(truong, dto);
        truongRepository.save(truong);
        return toResponseDTO(truong);
    }

    public void delete(UUID id) {
        truongRepository.deleteById(id);
    }

    private void updateEntity(Truong truong, TruongRequestDTO dto) {
        truong.setMaTruong(dto.getMaTruong());
        truong.setTenTruong(dto.getTenTruong());
        truong.setDiaChi(dto.getDiaChi());
        truong.setSoDienThoai(dto.getSoDienThoai());
        truong.setEmail(dto.getEmail());
        truong.setWebsite(dto.getWebsite());
        truong.setMoTa(dto.getMoTa());
        truong.setLogoUrl(dto.getLogoUrl());
        truong.setNgayThanhLap(dto.getNgayThanhLap());
        truong.setNguoiDaiDien(dto.getNguoiDaiDien());
    }

    private TruongResponseDTO toResponseDTO(Truong t) {
        return TruongResponseDTO.builder()
                .id(t.getId())
                .maTruong(t.getMaTruong())
                .tenTruong(t.getTenTruong())
                .diaChi(t.getDiaChi())
                .soDienThoai(t.getSoDienThoai())
                .email(t.getEmail())
                .website(t.getWebsite())
                .moTa(t.getMoTa())
                .logoUrl(t.getLogoUrl())
                .ngayThanhLap(t.getNgayThanhLap())
                .nguoiDaiDien(t.getNguoiDaiDien())
                .build();
    }
}