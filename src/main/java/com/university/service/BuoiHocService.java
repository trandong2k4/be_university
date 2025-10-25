package com.university.service;

import com.university.dto.reponse.BuoiHocResponseDTO;
import com.university.dto.request.BuoiHocRequestDTO;
import com.university.entity.BuoiHoc;
import com.university.entity.GioHoc;
import com.university.entity.LichHoc;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.BuoiHocMapper;
import com.university.repository.BuoiHocRepository;
import com.university.repository.GioHocRepository;
import com.university.repository.LichHocRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuoiHocService {

        private final BuoiHocRepository buoiHocRepository;
        private final GioHocRepository gioHocRepository;
        private final LichHocRepository lichHocRepository;
        private final BuoiHocMapper buoiHocMapper;

        public BuoiHocResponseDTO create(BuoiHocRequestDTO dto) {
                GioHoc gioHoc = gioHocRepository.findById(dto.getGioHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy giờ học"));
                LichHoc lichHoc = lichHocRepository.findById(dto.getLichHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch học"));

                BuoiHoc buoiHoc = buoiHocMapper.toEntity(dto, gioHoc, lichHoc);
                return buoiHocMapper.toResponseDTO(buoiHocRepository.save(buoiHoc));
        }

        @Transactional
        public List<BuoiHocResponseDTO> getAll() {
                return buoiHocRepository.findAll().stream()
                                .map(buoiHocMapper::toResponseDTO)
                                .toList();
        }

        public BuoiHocResponseDTO getById(UUID id) {
                BuoiHoc buoiHoc = buoiHocRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy buổi học"));
                return buoiHocMapper.toResponseDTO(buoiHoc);
        }

        public List<BuoiHocResponseDTO> search(String keyword) {
                return buoiHocRepository.searchByTenMonHoc(keyword).stream()
                                .map(buoiHocMapper::toResponseDTO)
                                .collect(Collectors.toList());
        }

        public List<BuoiHocResponseDTO> getByNgayHoc(LocalDate ngayHoc) {
                return buoiHocRepository.findByNgayHoc(ngayHoc).stream()
                                .map(buoiHocMapper::toResponseDTO)
                                .collect(Collectors.toList());
        }

        public BuoiHocResponseDTO update(UUID id, BuoiHocRequestDTO dto) {
                BuoiHoc existing = buoiHocRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy buổi học"));

                GioHoc gioHoc = gioHocRepository.findById(dto.getGioHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy giờ học"));
                LichHoc lichHoc = lichHocRepository.findById(dto.getLichHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch học"));

                existing.setNgayHoc(dto.getNgayHoc());
                existing.setThuTrongTuan(dto.getThuTrongTuan());
                existing.setGioHoc(gioHoc);
                existing.setLichHoc(lichHoc);
                existing.setGhiChu(dto.getGhiChu());

                return buoiHocMapper.toResponseDTO(buoiHocRepository.save(existing));
        }

        public void delete(UUID id) {
                buoiHocRepository.deleteById(id);
        }
}