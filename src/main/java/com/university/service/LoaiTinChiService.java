package com.university.service;

import com.university.dto.reponse.LoaiTinChiResponse;
import com.university.dto.request.LoaiTinChiRequest;
import com.university.entity.LoaiTinChi;
import com.university.mapper.LoaiTinChiMapper;
import com.university.repository.LoaiTinChiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LoaiTinChiService {

    private final LoaiTinChiRepository loaiTinChiRepository;
    private final LoaiTinChiMapper loaiTinChiMapper;

    public LoaiTinChiService(LoaiTinChiRepository loaiTinChiRepository, LoaiTinChiMapper loaiTinChiMapper) {
        this.loaiTinChiRepository = loaiTinChiRepository;
        this.loaiTinChiMapper = loaiTinChiMapper;
    }

    public LoaiTinChiResponse create(LoaiTinChiRequest request) {
        LoaiTinChi entity = loaiTinChiMapper.toEntity(request);
        entity = loaiTinChiRepository.save(entity);
        return loaiTinChiMapper.toResponse(entity);
    }

    public List<LoaiTinChiResponse> getAll() {
        return loaiTinChiRepository.findAll().stream()
                .map(loaiTinChiMapper::toResponse)
                .collect(Collectors.toList());
    }

    public LoaiTinChiResponse getById(UUID id) {
        LoaiTinChi entity = loaiTinChiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Loại tín chỉ không tồn tại"));
        return loaiTinChiMapper.toResponse(entity);
    }

    public LoaiTinChiResponse update(UUID id, LoaiTinChiRequest request) {
        LoaiTinChi entity = loaiTinChiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Loại tín chỉ không tồn tại"));
        loaiTinChiMapper.updateEntity(entity, request);
        entity = loaiTinChiRepository.save(entity);
        return loaiTinChiMapper.toResponse(entity);
    }

    public void delete(UUID id) {
        if (!loaiTinChiRepository.existsById(id)) {
            throw new EntityNotFoundException("Loại tín chỉ không tồn tại");
        }
        loaiTinChiRepository.deleteById(id);
    }
}
