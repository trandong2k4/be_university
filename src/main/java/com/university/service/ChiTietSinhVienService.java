package com.university.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.university.dto.reponse.ChiTietSinhVienResponse;
import com.university.dto.request.ChiTietSinhVienRequest;
import com.university.entity.ChiTietSinhVien;
import com.university.entity.SinhVien;
import com.university.mapper.ChiTietSinhVienMapper;
import com.university.repository.ChiTietSinhVienRepository;
import com.university.repository.SinhVienRepository;

@Service
public class ChiTietSinhVienService {

    private final ChiTietSinhVienRepository repository;
    private final SinhVienRepository sinhVienRepository;
    private final ChiTietSinhVienMapper mapper;

    public ChiTietSinhVienService(ChiTietSinhVienRepository repository,
            SinhVienRepository sinhVienRepository,
            ChiTietSinhVienMapper mapper) {
        this.repository = repository;
        this.sinhVienRepository = sinhVienRepository;
        this.mapper = mapper;
    }

    public ChiTietSinhVienResponse create(ChiTietSinhVienRequest request) {
        SinhVien sv = sinhVienRepository.findById(request.getSinhVienId()).orElseThrow();
        ChiTietSinhVien entity = mapper.toEntity(request, sv);
        return mapper.toResponse(repository.save(entity));
    }

    public ChiTietSinhVienResponse update(UUID id, ChiTietSinhVienRequest request) {
        ChiTietSinhVien ct = repository.findById(id).orElseThrow();
        SinhVien sv = sinhVienRepository.findById(request.getSinhVienId()).orElseThrow();

        ct.setDiaChi(request.getDiaChi());
        ct.setNgaySinh(request.getNgaySinh());
        ct.setGioiTinh(request.getGioiTinh());
        ct.setQuocTich(request.getQuocTich());
        ct.setCccd(request.getCccd());
        ct.setSdtNguoiThan(request.getSdtNguoiThan());
        ct.setSinhVien(sv);

        return mapper.toResponse(repository.save(ct));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public ChiTietSinhVienResponse getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow();
    }

    public List<ChiTietSinhVienResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ChiTietSinhVienResponse> search(String keyword) {
        return repository.findByDiaChiContainingIgnoreCase(keyword).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
