package com.university.service;

import com.university.dto.request.SinhVienRequestDTO;
import com.university.dto.response.SinhVienAdminResponseDTO;
import com.university.dto.response.SinhVienResponseDTO;
import com.university.entity.ChiTietSinhVien;
import com.university.entity.SinhVien;
import com.university.entity.Nganh;
import com.university.entity.User;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.SinhVienMapper;
import com.university.repository.ChiTietSinhVienRepository;
import com.university.repository.SinhVienRepository;
import com.university.repository.NganhRepository;
import com.university.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SinhVienService {

    private final SinhVienRepository SinhVienRepository;
    private final ChiTietSinhVienRepository chiTietSinhVienRepository;
    private final NganhRepository nganhRepository;
    private final UserRepository userRepository;
    private final SinhVienMapper SinhVienMapper;

    // 🔹 Tạo mới hoc viên
    public SinhVienResponseDTO create(SinhVienRequestDTO dto) {
        // 1️⃣ Tìm ngành
        Nganh nganh = nganhRepository.findById(dto.getNganhId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy ngành"));
        if (dto.getNgayNhapHoc() == null) {
            dto.setNgayNhapHoc(Time.valueOf(LocalDate.now().atStartOfDay().toLocalTime()));
        }
        if (dto.getMaSinhVien() == null || dto.getMaSinhVien().isEmpty()) {
            long count = SinhVienRepository.count();
            String generatedMaSV = "SV" + String.format("%05d", count + 1);
            dto.setMaSinhVien(generatedMaSV);
        }
        SinhVien hv = SinhVienMapper.toEntity(dto, nganh, null);
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user"));
            hv.setUser(user);
        }
        return SinhVienMapper.toResponseDTO(SinhVienRepository.save(hv));
    }

    // 🔹 Lấy theo ID
    public SinhVienResponseDTO getById(UUID id) {
        SinhVien sv = SinhVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy học viên"));
        return SinhVienMapper.toResponseDTO(sv);
    }

    public SinhVienResponseDTO findByUserId(UUID userId) {
        SinhVien sv = SinhVienRepository.findByUser_Id(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy học viên với userId: " + userId));

        return SinhVienMapper.toResponseDTO(sv);
    }

    // Trong StudentService
    public Optional<SinhVienResponseDTO> findByUserIdChatbot(UUID userId) {
        SinhVien entity = SinhVienRepository.findByUser_Id(userId)
                .orElseThrow(() -> new ResourceNotFoundException(""));
        return entity != null ? Optional.of(SinhVienMapper.toResponseDTO(entity)) : Optional.empty();
    }

    // 🔹 Tìm kiếm theo từ khóa
    public List<SinhVienResponseDTO> search(String keyword) {
        return SinhVienRepository.searchByHoTen(keyword).stream()
                .map(SinhVienMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // 🔹 Lấy tất cả hoc viên
    public List<SinhVienResponseDTO> getAll() {
        return SinhVienRepository.findAll().stream()
                .map(SinhVienMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // 🔹 Lấy tất cả học viên
    public List<SinhVienAdminResponseDTO> getAllAdmin() {
        return SinhVienRepository.findAll().stream()
                .map(SinhVienMapper::toResponseAdminDTO)
                .toList();
        // .collect(Collectors.toList());
    }

    // 🔹 Cập nhật hoc viên
    public SinhVienResponseDTO update(UUID id, SinhVienRequestDTO dto) {
        SinhVien sv = SinhVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy học viên"));

        sv.setMaSinhVien(dto.getMaSinhVien());
        sv.setHoTen(dto.getHoTen());
        sv.setNgayNhapHoc(dto.getNgayNhapHoc());
        if (dto.getNgayTotNghiep() != null) {
            dto.setNgayTotNghiep(dto.getNgayTotNghiep());
        }

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

        return SinhVienMapper.toResponseDTO(SinhVienRepository.save(sv));
    }

    // 🔹 Xóa hoc viên
    public void delete(UUID id) {
        if (!SinhVienRepository.existsById(id)) {
            throw new ResourceNotFoundException("Không tìm thấy học viên để xóa");
        }
        ChiTietSinhVien ct = chiTietSinhVienRepository.findBySinhVien_Id(id)
                .orElse(null);
        if (ct != null)
            chiTietSinhVienRepository.delete(ct);
        SinhVienRepository.deleteById(id);
    }
}