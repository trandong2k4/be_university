package com.university.service;

import com.university.dto.request.TruongRequestDTO;
import com.university.dto.response.TruongResponseDTO;
import com.university.entity.Truong;
import com.university.mapper.TruongMapper;
import com.university.repository.TruongRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TruongService {

    private final TruongRepository truongRepository;
    private final TruongMapper truongMapper;

    public List<TruongResponseDTO> getAll() {
        return truongRepository.findAllDTO();
    }

    public TruongResponseDTO getById(UUID id) {
        Truong truong = truongRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy trường"));

        return truongMapper.toResponseDTO(truong);
    }

    public TruongResponseDTO create(TruongRequestDTO dto) {
        if (truongRepository.existsByMaTruong(dto.getMaTruong())) {
            throw new RuntimeException("Mã trường đã tồn tại");
        }
        Truong truong = truongRepository.save(truongMapper.toEntity(dto));
        return truongMapper.toResponseDTO(truong);
    }

    public TruongResponseDTO update(UUID id, TruongRequestDTO dto) {
        Truong truong = truongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy trườnga"));
        truongMapper.updateEntity(truong, dto);
        truongRepository.save(truong);
        return truongMapper.toResponseDTO(truong);
    }

    public void delete(UUID id) {
        truongRepository.deleteById(id);
    }

}