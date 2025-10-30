package com.university.service;

import com.university.dto.reponse.LoaiTinChiResponseDTO;
import com.university.dto.request.LoaiTinChiRequestDTO;
import com.university.entity.LoaiTinChi;
import com.university.exception.DuplicateRequestException;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.LoaiTinChiMapper;
import com.university.repository.LoaiTinChiRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoaiTinChiService {

    private final LoaiTinChiRepository loaiTinChiRepository;
    private final LoaiTinChiMapper loaiTinChiMapper;

    public LoaiTinChiResponseDTO create(LoaiTinChiRequestDTO dto) {
        if (loaiTinChiRepository.findByMaLoaiTinChi(dto.getMaLoaiTinChi()).isPresent()) {
            throw new DuplicateRequestException("Mã loại tín chỉ đã tồn tại");
        }
        LoaiTinChi entity = loaiTinChiMapper.toEntity(dto);
        return loaiTinChiMapper.toResponseDTO(loaiTinChiRepository.save(entity));
    }

    public List<LoaiTinChiResponseDTO> getAll() {
        return loaiTinChiRepository.findAll().stream()
                .map(loaiTinChiMapper::toResponseDTO)
                .toList();
    }

    public LoaiTinChiResponseDTO getById(UUID id) {
        LoaiTinChi entity = loaiTinChiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy loại tín chỉ"));
        return loaiTinChiMapper.toResponseDTO(entity);
    }

    public List<LoaiTinChiResponseDTO> search(String keyword) {
        return loaiTinChiRepository.searchByTenLoaiTinChi(keyword).stream()
                .map(loaiTinChiMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public LoaiTinChiResponseDTO update(UUID id, LoaiTinChiRequestDTO dto) {
        LoaiTinChi existing = loaiTinChiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy loại tín chỉ"));

        existing.setMaLoaiTinChi(dto.getMaLoaiTinChi());
        existing.setTenLoaiTinChi(dto.getTenLoaiTinChi());

        return loaiTinChiMapper.toResponseDTO(loaiTinChiRepository.save(existing));
    }

    public void delete(UUID id) {
        loaiTinChiRepository.deleteById(id);
    }
}