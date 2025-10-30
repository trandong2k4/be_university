package com.university.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.university.dto.reponse.KetQuaHocTapResponseDTO;
import com.university.dto.request.KetQuaHocTapRequestDTO;
import com.university.entity.KetQuaHocTap;
import com.university.entity.KiHoc;
import com.university.entity.MonHoc;
import com.university.entity.SinhVien;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.KetQuaHocTapMapper;
import com.university.repository.KetQuaHocTapRepository;
import com.university.repository.KiHocRepository;
import com.university.repository.MonHocRepository;
import com.university.repository.SinhVienRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KetQuaHocTapService {

        private final KetQuaHocTapRepository ketQuaHocTapRepository;
        private final SinhVienRepository sinhVienRepository;
        private final MonHocRepository monHocRepository;
        private final KiHocRepository kiHocRepository;
        private final KetQuaHocTapMapper ketQuaHocTapMapper;

        public KetQuaHocTapResponseDTO create(KetQuaHocTapRequestDTO dto) {
                SinhVien sv = sinhVienRepository.findById(dto.getSinhVienId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên"));
                MonHoc monHoc = monHocRepository.findById(dto.getMonHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy môn học"));
                KiHoc kiHoc = kiHocRepository.findById(dto.getKiHocId())
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy kỳ học"));

                KetQuaHocTap kq = ketQuaHocTapMapper.toEntity(dto, sv, monHoc, kiHoc);
                return ketQuaHocTapMapper.toResponseDTO(ketQuaHocTapRepository.save(kq));
        }

        public List<KetQuaHocTapResponseDTO> getAll() {
                return ketQuaHocTapRepository.findAll().stream()
                                .map(ketQuaHocTapMapper::toResponseDTO)
                                .toList();
        }

        public KetQuaHocTapResponseDTO getById(UUID id) {
                KetQuaHocTap kq = ketQuaHocTapRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy kết quả học tập"));
                return ketQuaHocTapMapper.toResponseDTO(kq);
        }

        public List<KetQuaHocTapResponseDTO> search(String keyword) {
                return ketQuaHocTapRepository.searchByTenSinhVien(keyword).stream()
                                .map(ketQuaHocTapMapper::toResponseDTO)
                                .collect(Collectors.toList());
        }

        public KetQuaHocTapResponseDTO update(UUID id, KetQuaHocTapRequestDTO dto) {
                KetQuaHocTap existing = ketQuaHocTapRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy kết quả học tập"));

                existing.setDiem(dto.getDiem());
                existing.setDanhGia(dto.getDanhGia());
                existing.setGhiChu(dto.getGhiChu());
                existing.setNgayCapNhat(LocalDate.now());

                return ketQuaHocTapMapper.toResponseDTO(ketQuaHocTapRepository.save(existing));
        }

        public void delete(UUID id) {
                ketQuaHocTapRepository.deleteById(id);
        }
}
