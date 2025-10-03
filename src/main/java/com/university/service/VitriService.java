package com.university.service;

import com.university.dto.reponse.ViTriResponse;
import com.university.dto.request.ViTriRequest;
import com.university.entity.ViTri;
import com.university.mapper.ViTriMapper;
import com.university.repository.ViTriRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ViTriService {

    private final ViTriRepository viTriRepository;
    private final ViTriMapper viTriMapper;

    public ViTriService(ViTriRepository viTriRepository, ViTriMapper viTriMapper) {
        this.viTriRepository = viTriRepository;
        this.viTriMapper = viTriMapper;
    }

    public ViTriResponse create(ViTriRequest request) {
        ViTri viTri = viTriMapper.toEntity(request);
        viTri = viTriRepository.save(viTri);
        return viTriMapper.toResponse(viTri);
    }

    public List<ViTriResponse> getAll() {
        return viTriRepository.findAll().stream()
                .map(viTriMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ViTriResponse getById(UUID id) {
        ViTri viTri = viTriRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vị trí không tồn tại"));
        return viTriMapper.toResponse(viTri);
    }

    public ViTriResponse update(UUID id, ViTriRequest request) {
        ViTri viTri = viTriRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vị trí không tồn tại"));
        viTriMapper.updateEntity(viTri, request);
        viTri = viTriRepository.save(viTri);
        return viTriMapper.toResponse(viTri);
    }

    public void delete(UUID id) {
        if (!viTriRepository.existsById(id)) {
            throw new EntityNotFoundException("Vị trí không tồn tại");
        }
        viTriRepository.deleteById(id);
    }

    public List<ViTriResponse> searchByTenViTri(String keyword) {
        return viTriRepository.findByTenViTriContainingIgnoreCase(keyword).stream()
                .map(viTriMapper::toResponse)
                .collect(Collectors.toList());
    }
}
