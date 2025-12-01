package com.university.service;

import com.university.config.SecurityConfig;
import com.university.dto.reponse.SinhVienResponseDTO;
import com.university.dto.request.SinhVienRequestDTO;
import com.university.entity.Nganh;
import com.university.entity.Role;
import com.university.entity.SinhVien;
import com.university.entity.User;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.SinhVienMapper;
import com.university.repository.NganhRepository;
import com.university.repository.RoleRepository;
import com.university.repository.SinhVienRepository;
import com.university.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SinhVienService {

    private final SinhVienRepository sinhVienRepository;
    private final NganhRepository nganhRepository;
    private final UserRepository userRepository;
    private final SinhVienMapper sinhVienMapper;
    private final RoleRepository roleRepository;
    private final SecurityConfig securityConfig;

    // 🔹 Tạo mới sinh viên
    public SinhVienResponseDTO create(SinhVienRequestDTO dto) {
        // 1️⃣ Tìm ngành
        Nganh nganh = nganhRepository.findById(dto.getNganhId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy ngành"));

        // 2️⃣ Tạo user mới cho sinh viên
        Role studentRole = roleRepository.findByMaRole("STUDENT")
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy role STUDENT"));

        User user = User.builder()
                .username(dto.getHoTen().toLowerCase())
                .password(securityConfig.passwordEncoder().encode("123")) // ✅ Dùng BCrypt để mã hóa
                .createDate(LocalDate.now())
                .role(studentRole)
                .build();

        user = userRepository.save(user);

        SinhVien sv = sinhVienMapper.toEntity(dto, nganh, user);
        return sinhVienMapper.toResponseDTO(sinhVienRepository.save(sv));
    }

    // 🔹 Lấy theo ID
    public SinhVienResponseDTO getById(UUID id) {
        SinhVien sv = sinhVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên"));
        return sinhVienMapper.toResponseDTO(sv);
    }

    public SinhVienResponseDTO findByUserId(UUID userId) {
        SinhVien sv = sinhVienRepository.findByUser_Id(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên với userId: " + userId));

        return sinhVienMapper.toResponseDTO(sv);
    }

    // Trong StudentService
    public Optional<SinhVienResponseDTO> findByUserIdChatbot(UUID userId) {
        SinhVien entity = sinhVienRepository.findByUser_Id(userId)
                .orElseThrow(() -> new ResourceNotFoundException(""));
        return entity != null ? Optional.of(sinhVienMapper.toResponseDTO(entity)) : Optional.empty();
    }

    // 🔹 Tìm kiếm theo từ khóa
    public List<SinhVienResponseDTO> search(String keyword) {
        return sinhVienRepository.searchByHoTen(keyword).stream()
                .map(sinhVienMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // 🔹 Lấy tất cả sinh viên
    public List<SinhVienResponseDTO> getAll() {
        return sinhVienRepository.findAll().stream()
                .map(sinhVienMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // 🔹 Cập nhật sinh viên
    public SinhVienResponseDTO update(UUID id, SinhVienRequestDTO dto) {
        SinhVien sv = sinhVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên"));

        sv.setMaSinhVien(dto.getMaSinhVien());
        sv.setHoTen(dto.getHoTen());
        sv.setNgayNhapHoc(dto.getNgayNhapHoc());

        if (dto.getNganhId() != null) {
            Nganh nganh = nganhRepository.findById(dto.getNganhId())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy ngành"));
            sv.setNganh(nganh);
        }

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user"));
            sv.setUser(user);
        }

        return sinhVienMapper.toResponseDTO(sinhVienRepository.save(sv));
    }

    // 🔹 Xóa sinh viên
    public void delete(UUID id) {
        if (!sinhVienRepository.existsById(id)) {
            throw new ResourceNotFoundException("Không tìm thấy sinh viên để xóa");
        }
        sinhVienRepository.deleteById(id);
    }
}