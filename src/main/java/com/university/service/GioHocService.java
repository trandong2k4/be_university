package com.university.service;

import com.university.dto.reponse.GioHocResponse;
import com.university.dto.request.GioHocRequest;
import com.university.entity.GioHoc;
import com.university.mapper.GioHocMapper;
import com.university.repository.GioHocRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GioHocService {

    private final GioHocRepository gioHocRepository;
    private final GioHocMapper gioHocMapper;

    public GioHocService(GioHocRepository gioHocRepository, GioHocMapper gioHocMapper) {
        this.gioHocRepository = gioHocRepository;
        this.gioHocMapper = gioHocMapper;
    }

    public GioHocResponse create(GioHocRequest request) {
        GioHoc gio = gioHocMapper.toEntity(request);
        gio = gioHocRepository.save(gio);
        return gioHocMapper.toResponse(gio);
    }

    public List<GioHocResponse> getAll() {
        return gioHocRepository.findAll().stream()
                .map(gioHocMapper::toResponse)
                .collect(Collectors.toList());
    }
}