package com.university.service;

import com.university.dto.reponse.TinChiResponse;
import com.university.dto.request.TinChiRequest;
import com.university.entity.MonHoc;
import com.university.entity.TinChi;
import com.university.enums.LoaiTinChiEnum;
import com.university.mapper.TinChiMapper;
import com.university.repository.MonHocRepository;
import com.university.repository.TinChiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TinChiService {

    private final TinChiRepository tinChiRepository;
    private final MonHocRepository monHocRepository;
    private final TinChiMapper tinChiMapper;

    public TinChiService(TinChiRepository tinChiRepository,
            MonHocRepository monHocRepository,
            TinChiMapper tinChiMapper) {
        this.tinChiRepository = tinChiRepository;
        this.monHocRepository = monHocRepository;
        this.tinChiMapper = tinChiMapper;
    }

    public TinChiResponse create(TinChiRequest request) {
        MonHoc mon = monHocRepository.findById(request.getMonHocId())
                .orElseThrow(() -> new EntityNotFoundException("Môn học không tồn tại"));

        TinChi entity = tinChiMapper.toEntity(request, mon);
        entity = tinChiRepository.save(entity);
        return tinChiMapper.toResponse(entity);
    }

    public List<TinChiResponse> getAll() {
        return tinChiRepository.findAll().stream()
                .map(tinChiMapper::toResponse)
                .collect(Collectors.toList());
    }

    public TinChiResponse getById(UUID id) {
        TinChi entity = tinChiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tín chỉ không tồn tại"));
        return tinChiMapper.toResponse(entity);
    }

    public TinChiResponse update(UUID id, TinChiRequest request) {
        TinChi entity = tinChiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tín chỉ không tồn tại"));
        MonHoc mon = monHocRepository.findById(request.getMonHocId())
                .orElseThrow(() -> new EntityNotFoundException("Môn học không tồn tại"));

        tinChiMapper.updateEntity(entity, request, mon);
        entity = tinChiRepository.save(entity);
        return tinChiMapper.toResponse(entity);
    }

    public void delete(UUID id) {
        if (!tinChiRepository.existsById(id)) {
            throw new EntityNotFoundException("Tín chỉ không tồn tại");
        }
        tinChiRepository.deleteById(id);
    }

    public List<TinChiResponse> filterByMonHoc(UUID monHocId) {
        return tinChiRepository.findByMonHocId(monHocId).stream()
                .map(tinChiMapper::toResponse)
                .collect(Collectors.toList());
    }

    // public List<TinChiResponse> filterByLoaiTinChi(LoaiTinChiEnum loaiTinChiId) {
    // return tinChiRepository.findbyLoaiTinChi(loaiTinChiId).stream()
    // .map(tinChiMapper::toResponse)
    // .collect(Collectors.toList());
    // }

    public List<TinChiResponse> filterByGiaTri(BigDecimal minGiaTri) {
        return tinChiRepository.findByGiaTriTinChiGreaterThanEqual(minGiaTri).stream()
                .map(tinChiMapper::toResponse)
                .collect(Collectors.toList());
    }

}
