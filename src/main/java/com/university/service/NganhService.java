package com.university.service;

import com.university.dto.reponse.NganhResponse;
import com.university.dto.request.NganhRequest;
import com.university.entity.Khoa;
import com.university.entity.Nganh;
import com.university.mapper.NganhMapper;
import com.university.repository.KhoaRepository;
import com.university.repository.NganhRepository;
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
public class NganhService {

    private final NganhRepository nganhRepository;
    private final KhoaRepository khoaRepository;
    private final NganhMapper nganhMapper;

    public NganhService(NganhRepository nganhRepository, KhoaRepository khoaRepository,
            NganhMapper nganhMapper) {
        this.nganhRepository = nganhRepository;
        this.khoaRepository = khoaRepository;
        this.nganhMapper = nganhMapper;
    }

    public NganhResponse create(NganhRequest request) {
        Khoa khoa = khoaRepository.findById(request.getKhoaId())
                .orElseThrow(() -> new EntityNotFoundException("Khoa không tồn tại"));
        Nganh nganh = nganhMapper.toEntity(request, khoa);
        nganh = nganhRepository.save(nganh);
        return nganhMapper.toResponse(nganh);
    }

    public List<NganhResponse> getAll() {
        return nganhRepository.findAll().stream()
                .map(nganhMapper::toResponse)
                .collect(Collectors.toList());
    }

    public NganhResponse getById(UUID id) {
        Nganh nganh = nganhRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ngành học không tồn tại"));
        return nganhMapper.toResponse(nganh);
    }

    public NganhResponse update(UUID id, NganhRequest request) {
        Nganh nganh = nganhRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ngành học không tồn tại"));
        Khoa khoa = khoaRepository.findById(request.getKhoaId())
                .orElseThrow(() -> new EntityNotFoundException("Khoa không tồn tại"));
        nganhMapper.updateEntity(nganh, request, khoa);
        nganh = nganhRepository.save(nganh);
        return nganhMapper.toResponse(nganh);
    }

    public void delete(UUID id) {
        if (!nganhRepository.existsById(id)) {
            throw new EntityNotFoundException("Ngành học không tồn tại");
        }
        nganhRepository.deleteById(id);
    }

    public Page<NganhResponse> getByKhoa(UUID khoaId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("tenNganh").ascending());
        Page<Nganh> pageResult = nganhRepository.findByKhoaId(khoaId, pageable);
        return pageResult.map(nganhMapper::toResponse);
    }
}