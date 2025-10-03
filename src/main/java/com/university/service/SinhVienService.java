package com.university.service;

import com.university.dto.reponse.SinhVienResponse;
import com.university.dto.request.SinhVienRequest;
import com.university.entity.Nganh;
import com.university.entity.SinhVien;
import com.university.entity.User;
import com.university.mapper.SinhVienMapper;
import com.university.repository.NganhRepository;
import com.university.repository.SinhVienRepository;
import com.university.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SinhVienService {

    private final SinhVienRepository repository;
    private final NganhRepository nganhRepository;
    private final UserRepository userRepository;
    private final SinhVienMapper mapper;

    public SinhVienService(SinhVienRepository repository,
            NganhRepository nganhRepository,
            UserRepository userRepository,
            SinhVienMapper mapper) {
        this.repository = repository;
        this.nganhRepository = nganhRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public SinhVienResponse create(SinhVienRequest request) {
        Nganh nganh = nganhRepository.findById(request.getNganhId()).orElseThrow();
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        SinhVien sv = mapper.toEntity(request, nganh, user);
        return mapper.toResponse(repository.save(sv));
    }

    public SinhVienResponse update(UUID id, SinhVienRequest request) {
        SinhVien sv = repository.findById(id).orElseThrow();
        Nganh nganh = nganhRepository.findById(request.getNganhId()).orElseThrow();
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        sv.setMaSinhVien(request.getMaSinhVien());
        sv.setHoTen(request.getHoTen());
        sv.setEmail(request.getEmail());
        sv.setSoDienThoai(request.getSoDienThoai());
        sv.setNgayNhapHoc(request.getNgayNhapHoc());
        sv.setNgayTotNghiep(request.getNgayTotNghiep());
        sv.setNganh(nganh);
        sv.setUser(user);

        return mapper.toResponse(repository.save(sv));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public SinhVienResponse getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow();
    }

    public List<SinhVienResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<SinhVienResponse> search(String keyword) {
        return repository.findByHoTenContainingIgnoreCase(keyword).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}