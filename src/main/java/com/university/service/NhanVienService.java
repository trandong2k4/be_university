package com.university.service;

import com.university.dto.reponse.NhanVienResponseDTO;
import com.university.dto.request.NhanVienRequestDTO;
import com.university.entity.NhanVien;
import com.university.entity.User;
import com.university.entity.ViTri;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.NhanVienMapper;
import com.university.repository.NhanVienRepository;
import com.university.repository.UserRepository;
import com.university.repository.ViTriRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NhanVienService {

    private final NhanVienRepository nhanVienRepository;
    private final ViTriRepository viTriRepository;
    private final UserRepository userRepository;
    private final NhanVienMapper nhanVienMapper;

    public NhanVienResponseDTO create(NhanVienRequestDTO dto) {
        ViTri viTri = viTriRepository.findById(dto.getViTriId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy vị trí"));
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy người dùng"));
        NhanVien nv = nhanVienMapper.toEntity(dto, viTri, user);
        return nhanVienMapper.toResponseDTO(nhanVienRepository.save(nv));
    }

    public List<NhanVienResponseDTO> getAllGiangVien() {
        return nhanVienRepository.findByViTri_TenViTri("GIANG_VIEN").stream()
                .map(nhanVienMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public NhanVienResponseDTO getById(UUID id) {
        NhanVien nv = nhanVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân viên"));
        return nhanVienMapper.toResponseDTO(nv);
    }

    public List<NhanVienResponseDTO> getAll() {
        return nhanVienRepository.findAll().stream()
                .map(nhanVienMapper::toResponseDTO)
                .toList();
    }

    public List<NhanVienResponseDTO> search(String keyword) {
        return nhanVienRepository
                .findByHoTenContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword)
                .stream().map(nhanVienMapper::toResponseDTO)
                .toList();
    }

    public NhanVienResponseDTO update(UUID id, NhanVienRequestDTO dto) {
        NhanVien nv = nhanVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân viên"));
        nv.setHoTen(dto.getHoTen());
        nv.setEmail(dto.getEmail());
        nv.setSoDienThoai(dto.getSoDienThoai());
        nv.setNgayVaoLam(dto.getNgayVaoLam());
        nv.setNgayNghiViec(dto.getNgayNghiViec());

        if (dto.getViTriId() != null) {
            ViTri viTri = viTriRepository.findById(dto.getViTriId())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy vị trí"));
            nv.setViTri(viTri);
        }

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