package com.university.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.university.dto.reponse.KetQuaHocTapResponseDTO;
import com.university.dto.request.KetQuaHocTapRequestDTO;
import com.university.entity.KetQuaHocTap;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.KetQuaHocTapMapper;
import com.university.repository.KetQuaHocTapRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KetQuaHocTapService {

        private final KetQuaHocTapRepository ketQuaHocTapRepository;
        private final KetQuaHocTapMapper ketQuaHocTapMapper;

        public KetQuaHocTapResponseDTO create(KetQuaHocTapRequestDTO dto) {
                KetQuaHocTap kq = ketQuaHocTapMapper.toEntity(dto);
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

        public KetQuaHocTapResponseDTO update(UUID id, KetQuaHocTapRequestDTO dto) {
                KetQuaHocTap existing = ketQuaHocTapRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy kết quả học tập"));
                existing.setChuyenCan(dto.getChuyenCan());
                existing.setThuongKi(dto.getThuongKi());
                existing.setGiuaKi(dto.getGiuaKi());
                existing.setCuoiKi(dto.getCuoiKi());
                existing.setDanhGia(dto.getDanhGia());
                existing.setGhiChu(dto.getGhiChu());
                existing.setNgayCapNhat(LocalDate.now());
                return ketQuaHocTapMapper.toResponseDTO(ketQuaHocTapRepository.save(existing));
        }

        public void delete(UUID id) {
                ketQuaHocTapRepository.deleteById(id);
        }
}
