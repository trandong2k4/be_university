package com.university.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.university.dto.reponse.KetQuaHocTapResponse;
import com.university.dto.request.KetQuaHocTapRequest;
import com.university.entity.KetQuaHocTap;
import com.university.entity.KiHoc;
import com.university.entity.MonHoc;
import com.university.entity.SinhVien;
import com.university.mapper.KetQuaHocTapMapper;
import com.university.repository.KetQuaHocTapRepository;
import com.university.repository.KiHocRepository;
import com.university.repository.MonHocRepository;
import com.university.repository.SinhVienRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class KetQuaHocTapService {

        private final KetQuaHocTapRepository ketQuaHocTapRepository;
        private final SinhVienRepository sinhVienRepository;
        private final MonHocRepository monHocRepository;
        private final KiHocRepository kiHocRepository;
        private final KetQuaHocTapMapper ketQuaHocTapMapper;

        public KetQuaHocTapService(KetQuaHocTapRepository ketQuaHocTapRepository,
                        SinhVienRepository sinhVienRepository,
                        MonHocRepository monHocRepository,
                        KiHocRepository kiHocRepository,
                        KetQuaHocTapMapper ketQuaHocTapMapper) {
                this.ketQuaHocTapRepository = ketQuaHocTapRepository;
                this.sinhVienRepository = sinhVienRepository;
                this.monHocRepository = monHocRepository;
                this.kiHocRepository = kiHocRepository;
                this.ketQuaHocTapMapper = ketQuaHocTapMapper;
        }

        public KetQuaHocTapResponse create(KetQuaHocTapRequest request) {
                SinhVien sinhVien = sinhVienRepository.findById(request.getSinhVienId())
                                .orElseThrow(() -> new EntityNotFoundException("Sinh viên không tồn tại"));
                MonHoc monHoc = monHocRepository.findById(request.getMonHocId())
                                .orElseThrow(() -> new EntityNotFoundException("Môn học không tồn tại"));
                KiHoc kiHoc = kiHocRepository.findById(request.getKiHocId())
                                .orElseThrow(() -> new EntityNotFoundException("Kì học không tồn tại"));

                KetQuaHocTap entity = ketQuaHocTapMapper.toEntity(request, sinhVien, monHoc, kiHoc);
                entity = ketQuaHocTapRepository.save(entity);
                return ketQuaHocTapMapper.toResponse(entity);
        }

        public KetQuaHocTapResponse update(UUID id, KetQuaHocTapRequest request) {
                KetQuaHocTap entity = ketQuaHocTapRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("Kết quả học tập không tồn tại"));
                SinhVien sinhVien = sinhVienRepository.findById(request.getSinhVienId())
                                .orElseThrow(() -> new EntityNotFoundException("Sinh viên không tồn tại"));
                MonHoc monHoc = monHocRepository.findById(request.getMonHocId())
                                .orElseThrow(() -> new EntityNotFoundException("Môn học không tồn tại"));
                KiHoc kiHoc = kiHocRepository.findById(request.getKiHocId())
                                .orElseThrow(() -> new EntityNotFoundException("Kì học không tồn tại"));

                ketQuaHocTapMapper.updateEntity(entity, request, sinhVien, monHoc, kiHoc);
                entity = ketQuaHocTapRepository.save(entity);
                return ketQuaHocTapMapper.toResponse(entity);
        }

        public KetQuaHocTapResponse getById(UUID id) {
                KetQuaHocTap entity = ketQuaHocTapRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("Kết quả học tập không tồn tại"));
                return ketQuaHocTapMapper.toResponse(entity);
        }

        public List<KetQuaHocTapResponse> getAll() {
                return ketQuaHocTapRepository.findAll().stream()
                                .map(ketQuaHocTapMapper::toResponse)
                                .collect(Collectors.toList());
        }

        public void delete(UUID id) {
                if (!ketQuaHocTapRepository.existsById(id)) {
                        throw new EntityNotFoundException("Kết quả học tập không tồn tại");
                }
                ketQuaHocTapRepository.deleteById(id);
        }

        public List<KetQuaHocTapResponse> getBySinhVienId(UUID sinhVienId) {
                List<KetQuaHocTap> ketQuaList = ketQuaHocTapRepository.findBySinhVienId(sinhVienId);
                return ketQuaList.stream()
                                .map(ketQuaHocTapMapper::toResponse)
                                .collect(Collectors.toList());
        }
}
