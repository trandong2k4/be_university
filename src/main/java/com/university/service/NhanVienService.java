package com.university.service;

import com.university.dto.reponse.NhanVienResponse;
import com.university.dto.request.NhanVienRequest;
import com.university.entity.NhanVien;
import com.university.entity.User;
import com.university.entity.ViTri;
import com.university.mapper.NhanVienMapper;
import com.university.repository.NhanVienRepository;
import com.university.repository.UserRepository;
import com.university.repository.ViTriRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NhanVienService {

    private final NhanVienRepository nhanVienRepository;
    private final ViTriRepository viTriRepository;
    private final UserRepository userRepository;
    private final NhanVienMapper nhanVienMapper;

    public NhanVienService(NhanVienRepository nhanVienRepository, ViTriRepository viTriRepository,
            UserRepository userRepository, NhanVienMapper nhanVienMapper) {
        this.nhanVienRepository = nhanVienRepository;
        this.viTriRepository = viTriRepository;
        this.userRepository = userRepository;
        this.nhanVienMapper = nhanVienMapper;
    }

    public NhanVienResponse create(NhanVienRequest request) {
        ViTri viTri = viTriRepository.findById(request.getViTriId())
                .orElseThrow(() -> new EntityNotFoundException("Vị trí không tồn tại"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User không tồn tại"));
        NhanVien nv = nhanVienMapper.toEntity(request, viTri, user);
        nv = nhanVienRepository.save(nv);
        return nhanVienMapper.toResponse(nv);
    }

    public List<NhanVienResponse> getAll() {
        return nhanVienRepository.findAll().stream()
                .map(nhanVienMapper::toResponse)
                .collect(Collectors.toList());
    }

    public NhanVienResponse getById(UUID id) {
        NhanVien nv = nhanVienRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nhân viên không tồn tại"));
        return nhanVienMapper.toResponse(nv);
    }

    public NhanVienResponse update(UUID id, NhanVienRequest request) {
        NhanVien nv = nhanVienRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nhân viên không tồn tại"));
        ViTri viTri = viTriRepository.findById(request.getViTriId())
                .orElseThrow(() -> new EntityNotFoundException("Vị trí không tồn tại"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User không tồn tại"));
        nhanVienMapper.updateEntity(nv, request, viTri, user);
        nv = nhanVienRepository.save(nv);
        return nhanVienMapper.toResponse(nv);
    }

    public void delete(UUID id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new EntityNotFoundException("Nhân viên không tồn tại");
        }
        nhanVienRepository.deleteById(id);
    }
}