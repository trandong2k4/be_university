package com.university.service;

import com.university.dto.request.BaiVietRequestDTO;
import com.university.dto.response.BaiVietResponseDTO;
import com.university.entity.BaiViet;
import com.university.entity.User;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.BaiVietMapper;
import com.university.repository.BaiVietRepository;
import com.university.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaiVietService {

    private final BaiVietRepository baiVietRepository;
    private final UserRepository userRepository;
    private final BaiVietMapper baiVietMapper;

    public BaiVietResponseDTO create(BaiVietRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy người đăng bài"));

        BaiViet baiViet = baiVietMapper.toEntity(dto, user);
        return baiVietMapper.toResponseDTO(baiVietRepository.save(baiViet));
    }

    public List<BaiVietResponseDTO> getAll() {
        return baiVietRepository.findAll().stream()
                .map(baiVietMapper::toResponseDTO)
                .toList();
    }

    public BaiVietResponseDTO getById(UUID id) {
        BaiViet baiViet = baiVietRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy bài viết"));
        return baiVietMapper.toResponseDTO(baiViet);
    }

    public List<BaiVietResponseDTO> search(String keyword) {
        return baiVietRepository.searchByTieuDe(keyword).stream()
                .map(baiVietMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public BaiVietResponseDTO update(UUID id, BaiVietRequestDTO dto) {
        BaiViet existing = baiVietRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy bài viết"));

        existing.setTieuDe(dto.getTieuDe());
        existing.setNoiDung(dto.getNoiDung());
        existing.setLoaiBaiViet(dto.getLoaiBaiViet());
        existing.setTacGia(dto.getTacGia());
        existing.setTrangThai(dto.getTrangThai());
        existing.setHinhAnhUrl(dto.getHinhAnhUrl());
        existing.setFileDinhKemUrl(dto.getFileDinhKemUrl());

        return baiVietMapper.toResponseDTO(baiVietRepository.save(existing));
    }

    public void delete(UUID id) {
        baiVietRepository.deleteById(id);
    }
}