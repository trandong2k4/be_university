package com.university.service;

import com.university.dto.request.KiHocRequest;
import com.university.dto.request.KiHocResponse;
import com.university.entity.KiHoc;
import com.university.mapper.KiHocMapper;
import com.university.repository.KiHocRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class KiHocService {

    private final KiHocRepository kiHocRepository;
    private final KiHocMapper kiHocMapper;

    public KiHocService(KiHocRepository kiHocRepository, KiHocMapper kiHocMapper) {
        this.kiHocRepository = kiHocRepository;
        this.kiHocMapper = kiHocMapper;
    }

    public KiHocResponse create(KiHocRequest request) {
        KiHoc entity = kiHocMapper.toEntity(request);
        entity = kiHocRepository.save(entity);
        return kiHocMapper.toResponse(entity);
    }

    public List<KiHocResponse> getAll() {
        return kiHocRepository.findAll().stream()
                .map(kiHocMapper::toResponse)
                .collect(Collectors.toList());
    }

    public KiHocResponse getById(UUID id) {
        KiHoc entity = kiHocRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kì học không tồn tại"));
        return kiHocMapper.toResponse(entity);
    }

    public KiHocResponse update(UUID id, KiHocRequest request) {
        KiHoc entity = kiHocRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kì học không tồn tại"));
        kiHocMapper.updateEntity(entity, request);
        entity = kiHocRepository.save(entity);
        return kiHocMapper.toResponse(entity);
    }

    public void delete(UUID id) {
        if (!kiHocRepository.existsById(id)) {
            throw new EntityNotFoundException("Kì học không tồn tại");
        }
        kiHocRepository.deleteById(id);
    }
}