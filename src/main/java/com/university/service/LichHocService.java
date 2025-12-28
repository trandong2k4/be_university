package com.university.service;

import com.university.dto.request.LichHocRequestDTO;
import com.university.dto.response.LichHocResponseDTO;
import com.university.dto.response.LichHocSinhVienResponseDTO;
import com.university.entity.GioHoc;
import com.university.entity.LichHoc;
import com.university.entity.LopHocPhan;
import com.university.entity.PhongHoc;
import com.university.exception.ResourceNotFoundException;
import com.university.exception.SimpleMessageException;
import com.university.mapper.LichHocMapper;
import com.university.repository.GioHocRepository;
import com.university.repository.LichHocRepository;
import com.university.repository.LopHocPhanRepository;
import com.university.repository.PhongHocRepository;

// import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LichHocService {

        private final LichHocRepository lichHocRepository;
        private final LichHocMapper lichHocMapper;
        private final GioHocRepository gioHocRepository;
        private final LopHocPhanRepository lopHocPhanRepository;
        private final PhongHocRepository phongHocRepository;

        public LichHocResponseDTO create(LichHocRequestDTO dto) {
                // 1. Kiểm tra sự tồn tại của các thực thể liên quan
                GioHoc gioHoc = gioHocRepository.findById(dto.getGioHocId())
                                .orElseThrow(() -> new SimpleMessageException("Không tìm thấy giờ học"));
                PhongHoc phongHoc = phongHocRepository.findById(dto.getPhongHocId())
                                .orElseThrow(() -> new SimpleMessageException("Không tìm thấy phòng học"));
                LopHocPhan lopHocPhan = lopHocPhanRepository.findById(dto.getLopHocPhanId())
                                .orElseThrow(() -> new SimpleMessageException("Không tìm thấy lớp học phần"));

                // 2. Logic kiểm tra trùng lịch
                // Tìm tất cả lịch học của Lớp học phần này
                List<LichHoc> existingSchedules = lichHocRepository.findByLopHocPhanId(dto.getLopHocPhanId());

                for (LichHoc existing : existingSchedules) {
                        // Kiểm tra nếu trùng ngày học
                        if (existing.getNgayHoc().equals(dto.getNgayHoc())) {
                                // Nếu trùng ngày, tiếp tục kiểm tra trùng Giờ học (ID)
                                if (existing.getGioHoc().getId().equals(dto.getGioHocId())) {
                                        throw new SimpleMessageException("Lớp học phần này đã có lịch vào ngày "
                                                        + dto.getNgayHoc() + " tại khung giờ này!");
                                }
                        }
                }

                // 3. Nếu vượt qua kiểm tra, tiến hành lưu
                LichHoc lichHoc = lichHocMapper.toEntity(dto, gioHoc, phongHoc, lopHocPhan);
                return lichHocMapper.toResponseDTO(lichHocRepository.save(lichHoc));
        }

        public List<LichHocResponseDTO> getAll() {
                return lichHocRepository.findAll()
                                .stream()
                                .map(lichHocMapper::toResponseDTO)
                                .toList();
        }

        public LichHocResponseDTO getById(UUID id) {
                LichHoc lichHoc = lichHocRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch học"));
                return lichHocMapper.toResponseDTO(lichHoc);
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