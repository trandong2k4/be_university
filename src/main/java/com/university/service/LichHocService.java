package com.university.service;

import com.university.dto.reponse.LichHocResponseDTO;
import com.university.dto.request.LichHocRequestDTO;
import com.university.entity.KiHoc;
import com.university.entity.LichHoc;
import com.university.entity.MonHoc;
import com.university.entity.PhongHoc;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.LichHocMapper;
import com.university.repository.KiHocRepository;
import com.university.repository.LichHocRepository;
import com.university.repository.MonHocRepository;
import com.university.repository.PhongHocRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LichHocService {

        private final LichHocRepository lichHocRepository;
        private final MonHocRepository monHocRepository;
        private final PhongHocRepository phongHocRepository;
        private final KiHocRepository kiHocRepository;
        private final LichHocMapper lichHocMapper;

        public LichHocResponseDTO create(LichHocRequestDTO dto) {
                MonHoc monHoc = monHocRepository.findById(dto.getMonHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy môn học"));
                PhongHoc phongHoc = phongHocRepository.findById(dto.getPhongHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng học"));
                KiHoc kiHoc = kiHocRepository.findById(dto.getKiHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy kỳ học"));

                LichHoc lichHoc = lichHocMapper.toEntity(dto, monHoc, phongHoc, kiHoc);
                return lichHocMapper.toResponseDTO(lichHocRepository.save(lichHoc));
        }

        public LichHocResponseDTO getById(UUID id) {
                LichHoc lichHoc = lichHocRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch học"));
                return lichHocMapper.toResponseDTO(lichHoc);
        }

        public List<LichHocResponseDTO> getAll() {
                return lichHocRepository.findAll().stream()
                                .map(lichHocMapper::toResponseDTO)
                                .collect(Collectors.toList());
        }

        public List<LichHocResponseDTO> search(String keyword) {
                return lichHocRepository.searchByTenMonHoc(keyword).stream()
                                .map(lichHocMapper::toResponseDTO)
                                .collect(Collectors.toList());
        }

        public LichHocResponseDTO update(UUID id, LichHocRequestDTO dto) {
                LichHoc existing = lichHocRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch học"));

                existing.setNgayBatDau(dto.getNgayBatDau());
                existing.setNgayKetThuc(dto.getNgayKetThuc());

                return lichHocMapper.toResponseDTO(lichHocRepository.save(existing));
        }

        public void delete(UUID id) {
                lichHocRepository.deleteById(id);
        }
}