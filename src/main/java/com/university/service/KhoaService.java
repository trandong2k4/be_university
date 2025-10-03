package com.university.service;

import com.university.dto.reponse.KhoaResponse;
import com.university.dto.request.KhoaRequest;
import com.university.entity.Khoa;
import com.university.entity.Truong;
import com.university.mapper.KhoaMapper;
import com.university.repository.KhoaRepository;
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
public class KhoaService {

    private final KhoaRepository khoaRepository;
    private final TruongRepository truongRepository;
    private final KhoaMapper khoaMapper;

    public KhoaService(KhoaRepository khoaRepository, TruongRepository truongRepository, KhoaMapper khoaMapper) {
        this.khoaRepository = khoaRepository;
        this.truongRepository = truongRepository;
        this.khoaMapper = khoaMapper;
    }

    public KhoaResponse create(KhoaRequest request) {
        Truong truong = truongRepository.findById(request.getTruongId())
                .orElseThrow(() -> new EntityNotFoundException("Trường không tồn tại"));
        Khoa khoa = khoaMapper.toEntity(request, truong);
        khoa = khoaRepository.save(khoa);
        return khoaMapper.toResponse(khoa);
    }

    public List<KhoaResponse> getAll() {
        return khoaRepository.findAll().stream()
                .map(khoaMapper::toResponse)
                .collect(Collectors.toList());
    }

    public KhoaResponse getById(UUID id) {
        Khoa khoa = khoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Khoa không tồn tại"));
        return khoaMapper.toResponse(khoa);
    }

    public KhoaResponse update(UUID id, KhoaRequest request) {
        Khoa khoa = khoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Khoa không tồn tại"));
        Truong truong = truongRepository.findById(request.getTruongId())
                .orElseThrow(() -> new EntityNotFoundException("Trường không tồn tại"));
        khoaMapper.updateEntity(khoa, request, truong);
        khoa = khoaRepository.save(khoa);
        return khoaMapper.toResponse(khoa);
    }

    public void delete(UUID id) {
        if (!khoaRepository.existsById(id)) {
            throw new EntityNotFoundException("Khoa không tồn tại");
        }
        khoaRepository.deleteById(id);
    }

    public Page<KhoaResponse> getByTruong(UUID truongId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("tenKhoa").ascending());
        Page<Khoa> khoas = khoaRepository.findByTruongId(truongId, pageable);
        return khoas.map(khoaMapper::toResponse);
    }
}