package com.university.service;

import com.university.dto.request.NhanVienRequestDTO;
import com.university.dto.response.NhanVienResponseDTO;
import com.university.dto.response.NhanVienResponseDTO.NhanVienView;
import com.university.entity.NhanVien;
import com.university.entity.User;
import com.university.enums.ViTriEnum;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.NhanVienMapper;
import com.university.repository.NhanVienRepository;
import com.university.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NhanVienService {

    private final NhanVienRepository nhanVienRepository;
    private final UserRepository userRepository;
    private final NhanVienMapper nhanVienMapper;

    public NhanVienResponseDTO create(NhanVienRequestDTO dto) {
        User user = new User();
        if (!dto.getUserId().equals(null)) {
            user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy người dùng"));
        }
        NhanVien nv = nhanVienMapper.toEntity(dto, user);
        return nhanVienMapper.toResponseDTO(nhanVienRepository.save(nv));
    }

    public NhanVienResponseDTO getById(UUID id) {
        NhanVien nv = nhanVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân viên"));
        return nhanVienMapper.toResponseDTO(nv);
    }

    public NhanVienView getNhanVienByUserId(UUID userId) {
        NhanVienView nhanVienView = nhanVienRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân viên"));
        return nhanVienView;
    }

    public List<NhanVienResponseDTO> getAll() {
        return nhanVienRepository.findAll().stream()
                .map(nhanVienMapper::toResponseDTO)
                .toList();
    }

    public List<NhanVienResponseDTO> getAllNhanVien(ViTriEnum viTri) {
        return nhanVienRepository.findByViTri(viTri).stream()
                .map(nhanVienMapper::toResponseDTO)
                .toList();
    }

    public NhanVienResponseDTO update(UUID id, NhanVienRequestDTO dto) {
        NhanVien nv = nhanVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân viên"));
        nv.setHoTen(dto.getHoTen());
        nv.setSoDienThoai(dto.getSoDienThoai());
        nv.setNgayVaoLam(dto.getNgayVaoLam());
        nv.setNgayNghiViec(dto.getNgayNghiViec());
        nv.setViTri(dto.getViTri());
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy người dùng"));
            nv.setUser(user);
        }

        return nhanVienMapper.toResponseDTO(nhanVienRepository.save(nv));
    }

    public void delete(UUID id) {
        nhanVienRepository.deleteById(id);
    }
}