package com.university.service;

import com.university.dto.reponse.LichHocResponseDTO;
import com.university.dto.request.LichHocRequestDTO;
import com.university.entity.GioHoc;
import com.university.entity.LichHoc;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.LichHocMapper;
import com.university.repository.GioHocRepository;
import com.university.repository.LichHocRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LichHocService {

        private final LichHocRepository lichHocRepository;
        private final LichHocMapper lichHocMapper;
        private final GioHocRepository gioHocRepository;

        public LichHocResponseDTO create(LichHocRequestDTO dto) {
                GioHoc gioHoc = gioHocRepository.findById(dto.getGioHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy giờ học"));

                LichHoc lichHoc = lichHocMapper.toEntity(dto, gioHoc);
                return lichHocMapper.toResponseDTO(lichHocRepository.save(lichHoc));
        }

        @Transactional
        public List<LichHocResponseDTO> getAll() {
                return lichHocRepository.findAll().stream()
                                .map(lichHocMapper::toResponseDTO)
                                .toList();
        }

        public LichHocResponseDTO getById(UUID id) {
                LichHoc lichHoc = lichHocRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy buổi học"));
                return lichHocMapper.toResponseDTO(lichHoc);
        }

        // public List<LichHocResponseDTO> search(String keyword) {
        // return lichHocRepository.searchByTenMonHoc(keyword).stream()
        // .map(lichHocMapper::toResponseDTO)
        // .collect(Collectors.toList());
        // }

        // public List<LichHocResponseDTO> getByNgayHoc(LocalDate ngayHoc) {
        // return lichHocRepository.findByNgayHoc(ngayHoc).stream()
        // .map(lichHocMapper::toResponseDTO)
        // .collect(Collectors.toList());
        // }

        public LichHocResponseDTO update(UUID id, LichHocRequestDTO dto) {
                LichHoc existing = lichHocRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lich học"));

                GioHoc gioHoc = gioHocRepository.findById(dto.getGioHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy giờ học"));

                existing.setNgayHoc(dto.getNgayHoc());
                // existing.setThuTrongTuan(dto.getThuTrongTuan());
                existing.setGioHoc(gioHoc);
                existing.setGhiChu(dto.getGhiChu());

                return lichHocMapper.toResponseDTO(lichHocRepository.save(existing));
        }

        public void delete(UUID id) {
                lichHocRepository.deleteById(id);
        }
}