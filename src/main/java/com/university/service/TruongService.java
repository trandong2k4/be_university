package com.university.service;

import com.university.dto.reponse.TruongResponse;
import com.university.dto.request.TruongRequest;
import com.university.entity.Truong;
import com.university.mapper.TruongMapper;
import com.university.repository.TruongRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;  
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TruongService {

    private final TruongRepository truongRepository;
    private final TruongMapper truongMapper;

    public TruongService(TruongRepository truongRepository, TruongMapper truongMapper) {
        this.truongRepository = truongRepository;
        this.truongMapper = truongMapper;
    }

    public TruongResponse create(TruongRequest request) {
        Truong truong = truongMapper.toEntity(request);
        truong = truongRepository.save(truong);
        return truongMapper.toResponse(truong);
    }

    public List<TruongResponse> getAll() {
        return truongRepository.findAll().stream()
                .map(truongMapper::toResponse)
                .collect(Collectors.toList());
    }

    public TruongResponse getById(UUID id) {
        Truong truong = truongRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trường không tồn tại"));
        return truongMapper.toResponse(truong);
    }

    public TruongResponse update(UUID id, TruongRequest request) {
        Truong truong = truongRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trường không tồn tại"));
        truongMapper.updateEntity(truong, request);
        truong = truongRepository.save(truong);
        return truongMapper.toResponse(truong);
    }

    public void delete(UUID id) {
        if (!truongRepository.existsById(id)) {
            throw new EntityNotFoundException("Trường không tồn tại");
        }
        truongRepository.deleteById(id);
    }

    public List<TruongResponse> searchByMaTruong(String keyword) {
        return truongRepository.findByMaTruongContainingIgnoreCase(keyword).stream()
                .map(truongMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Page<TruongResponse> getByDiaChi(String diaChi, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("tenTruong").ascending());
        Page<Truong> truongs = truongRepository.findByDiaChiContainingIgnoreCase(diaChi, pageable);
        return truongs.map(truongMapper::toResponse);
    }
}