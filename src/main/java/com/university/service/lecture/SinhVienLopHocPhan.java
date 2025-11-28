package com.university.service.lecture;

import com.university.dto.reponse.SinhVienResponseDTO;

import com.university.mapper.SinhVienMapper;
import com.university.repository.SinhVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SinhVienLopHocPhan {

    private final SinhVienRepository sinhVienRepository;
    private final SinhVienMapper sinhVienMapper;

    // Danh sach Sv lop hoc phan
    // public List<SinhVienResponseDTO> getAllSinhVienLHP(UUID id) {
    // return sinhVienRepository.searchByHoTen(keyword).stream()
    // .map(sinhVienMapper::toResponseDTO)
    // .collect(Collectors.toList());
    // }
}