package com.university.service;

import com.university.dto.reponse.LichHocChiTietDTO;
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

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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
                LichHoc lichHoc = lichHocMapper.toEntity(dto);
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
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch học"));
                return lichHocMapper.toResponseDTO(lichHoc);
        }

        // public List<LichHoc> findLichHocBySinhVienId(UUID sinhVienId) {

        // List<LichHoc> lichHocs =
        // lichHocRepository.findLichHocBySinhVienId(sinhVienId);

        // // Trả về danh sách, nếu không có kết quả thì trả về List rỗng.
        // if (lichHocs.isEmpty()) {
        // return new ArrayList<>();
        // }
        // return lichHocs;
        // }

        // public List<LichHoc> findLichDayByGiangVienId(UUID giangVienId) {
        // List<LichHoc> lichDay =
        // lichHocRepository.findLichHocByGiangVienId(giangVienId);

        // if (lichDay.isEmpty()) {
        // return new ArrayList<>();
        // }
        // return lichDay;
        // }

        public List<LichHocChiTietDTO> findAllLichHocDetails() {
                List<Object[]> results = lichHocRepository.findFullLichHocDetailsNative();

                return results.stream()
                                .map(row -> {
                                        // Chuyển đổi các kiểu dữ liệu cũ (java.sql) sang kiểu Java 8 (java.time)
                                        LocalDate ngayHoc = ((Date) row[5]).toLocalDate();
                                        LocalTime gioBatDau = ((Time) row[6]).toLocalTime();
                                        LocalTime gioKetThuc = ((Time) row[7]).toLocalTime();

                                        return new LichHocChiTietDTO(
                                                        (String) row[0], // ma_lop_hoc_phan
                                                        (String) row[1], // ten_mon_hoc
                                                        (String) row[2], // ten_giang_vien
                                                        (String) row[3], // ten_phong
                                                        (String) row[4], // toa_nha
                                                        ngayHoc, // đã chuyển đổi
                                                        gioBatDau, // đã chuyển đổi
                                                        gioKetThuc // đã chuyển đổi
                                        );
                                })
                                .collect(Collectors.toList());
        }

        public List<LichHocChiTietDTO> findLichHocDetailsBySinhVienId(UUID sinhVienId) {
                List<Object[]> results = lichHocRepository.findFullLichHocDetailsBySinhVienIdNative(sinhVienId);

                return results.stream()
                                .map(row -> {
                                        // Chuyển đổi từ java.sql.Date/Time sang java.time.LocalDate/LocalTime
                                        LocalDate ngayHoc = (row[5] != null) ? ((Date) row[5]).toLocalDate() : null;
                                        LocalTime gioBatDau = (row[6] != null) ? ((Time) row[6]).toLocalTime() : null;
                                        LocalTime gioKetThuc = (row[7] != null) ? ((Time) row[7]).toLocalTime() : null;

                                        return new LichHocChiTietDTO(
                                                        (String) row[0], // ma_lop_hoc_phan
                                                        (String) row[1], // ten_mon_hoc
                                                        (String) row[2], // ten_giang_vien
                                                        (String) row[3], // ten_phong
                                                        (String) row[4], // toa_nha
                                                        ngayHoc,
                                                        gioBatDau,
                                                        gioKetThuc);
                                })
                                .collect(Collectors.toList());
        }

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