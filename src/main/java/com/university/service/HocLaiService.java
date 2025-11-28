// package com.university.service;

// import java.util.List;
// import java.util.UUID;
// import java.util.stream.Collectors;
// import org.springframework.stereotype.Service;
// import com.university.dto.reponse.HocLaiResponseDTO;
// import com.university.dto.request.HocLaiRequestDTO;
// import com.university.entity.HocLai;
// import com.university.entity.KiHoc;
// import com.university.entity.MonHoc;
// import com.university.entity.SinhVien;
// import com.university.exception.ResourceNotFoundException;
// import com.university.mapper.HocLaiMapper;
// import com.university.repository.HocLaiRepository;
// import com.university.repository.KiHocRepository;
// import com.university.repository.MonHocRepository;
// import com.university.repository.SinhVienRepository;
// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class HocLaiService {

// private final HocLaiRepository hocLaiRepository;
// private final SinhVienRepository sinhVienRepository;
// private final MonHocRepository monHocRepository;
// private final KiHocRepository kiHocRepository;
// private final HocLaiMapper hocLaiMapper;

// public HocLaiResponseDTO create(HocLaiRequestDTO dto) {
// SinhVien sv = sinhVienRepository.findById(dto.getSinhVienId())
// .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh
// viên"));
// MonHoc monHoc = monHocRepository.findById(dto.getMonHocId())
// .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy môn học"));
// KiHoc kiHoc = kiHocRepository.findById(dto.getKiHocId())
// .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy kỳ học"));

// HocLai hocLai = hocLaiMapper.toEntity(dto, sv, monHoc, kiHoc);
// return hocLaiMapper.toResponseDTO(hocLaiRepository.save(hocLai));
// }

// public List<HocLaiResponseDTO> getAll() {
// return hocLaiRepository.findAll().stream()
// .map(hocLaiMapper::toResponseDTO)
// .toList();
// }

// public HocLaiResponseDTO getById(UUID id) {
// HocLai hocLai = hocLaiRepository.findById(id)
// .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy thông tin
// học lại"));
// return hocLaiMapper.toResponseDTO(hocLai);
// }

// public List<HocLaiResponseDTO> search(String keyword) {
// return hocLaiRepository.searchByTenSinhVien(keyword).stream()
// .map(hocLaiMapper::toResponseDTO)
// .collect(Collectors.toList());
// }

// public HocLaiResponseDTO update(UUID id, HocLaiRequestDTO dto) {
// HocLai existing = hocLaiRepository.findById(id)
// .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy thông tin
// học lại"));

// existing.setLyDo(dto.getLyDo());
// existing.setDiemCu(dto.getDiemCu());
// existing.setLanHoc(dto.getLanHoc());
// existing.setTrangThai(dto.getTrangThai());
// // existing.setGhiChu(dto.getGhiChu());
// // existing.setNgayDangKy(LocalDate.now());

// return hocLaiMapper.toResponseDTO(hocLaiRepository.save(existing));
// }

// public void delete(UUID id) {
// hocLaiRepository.deleteById(id);
// }
// }