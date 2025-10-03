package com.university.service;

import com.university.dto.reponse.MonHocResponse;
import com.university.dto.request.MonHocRequest;
import com.university.entity.MonHoc;
import com.university.mapper.MonHocMapper;
import com.university.repository.MonHocRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MonHocService {

    private final MonHocRepository monHocRepository;
    private final MonHocMapper monHocMapper;

    public MonHocService(MonHocRepository monHocRepository, MonHocMapper monHocMapper) {
        this.monHocRepository = monHocRepository;
        this.monHocMapper = monHocMapper;
    }

    public MonHocResponse create(MonHocRequest request) {
        MonHoc entity = monHocMapper.toEntity(request);
        entity = monHocRepository.save(entity);
        return monHocMapper.toResponse(entity);
    }

    public List<MonHocResponse> getAll() {
        return monHocRepository.findAll().stream()
                .map(monHocMapper::toResponse)
                .collect(Collectors.toList());
    }

    public MonHocResponse getById(UUID id) {
        MonHoc entity = monHocRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Môn học không tồn tại"));
        return monHocMapper.toResponse(entity);
    }

    public MonHocResponse update(UUID id, MonHocRequest request) {
        MonHoc entity = monHocRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Môn học không tồn tại"));
        monHocMapper.updateEntity(entity, request);
        entity = monHocRepository.save(entity);
        return monHocMapper.toResponse(entity);
    }

    public void delete(UUID id) {
        if (!monHocRepository.existsById(id)) {
            throw new EntityNotFoundException("Môn học không tồn tại");
        }
        monHocRepository.deleteById(id);
    }
}