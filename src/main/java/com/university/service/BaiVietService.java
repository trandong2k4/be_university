package com.university.service;

import com.university.dto.reponse.BaiVietResponse;
import com.university.dto.request.BaiVietRequest;
import com.university.entity.BaiViet;
import com.university.entity.User;
import com.university.mapper.BaiVietMapper;
import com.university.repository.BaiVietRepository;
import com.university.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BaiVietService {

    private final BaiVietRepository baiVietRepository;
    private final UserRepository userRepository;
    private final BaiVietMapper baiVietMapper;

    public BaiVietService(BaiVietRepository baiVietRepository,
            UserRepository userRepository,
            BaiVietMapper baiVietMapper) {
        this.baiVietRepository = baiVietRepository;
        this.userRepository = userRepository;
        this.baiVietMapper = baiVietMapper;
    }

    public BaiVietResponse create(BaiVietRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Người dùng không tồn tại"));

        BaiViet baiViet = baiVietMapper.toEntity(request, user);
        baiViet = baiVietRepository.save(baiViet);
        return baiVietMapper.toResponse(baiViet);
    }

    public BaiVietResponse update(UUID id, BaiVietRequest request) {
        BaiViet baiViet = baiVietRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bài viết không tồn tại"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Người dùng không tồn tại"));

        baiVietMapper.updateEntity(baiViet, request, user);
        baiViet = baiVietRepository.save(baiViet);
        return baiVietMapper.toResponse(baiViet);
    }

    public BaiVietResponse getById(UUID id) {
        BaiViet baiViet = baiVietRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bài viết không tồn tại"));
        return baiVietMapper.toResponse(baiViet);
    }

    public List<BaiVietResponse> getAll() {
        return baiVietRepository.findAll().stream()
                .map(baiVietMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(UUID id) {
        if (!baiVietRepository.existsById(id)) {
            throw new EntityNotFoundException("Bài viết không tồn tại");
        }
        baiVietRepository.deleteById(id);
    }
}