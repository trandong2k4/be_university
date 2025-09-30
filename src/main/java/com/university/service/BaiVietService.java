package com.university.service;

import com.university.entity.BaiViet;
import com.university.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BaiVietService {

    @Autowired
    private BaiVietRepository baiVietRepository;

    public List<BaiViet> findAll() {
        return baiVietRepository.findAll();
    }

    public Optional<BaiViet> findById(UUID id) {
        return baiVietRepository.findById(id);
    }

    public BaiViet save(BaiViet baiViet) {
        return baiVietRepository.save(baiViet);
    }

    public void deleteById(UUID id) {
        baiVietRepository.deleteById(id);
    }
}
