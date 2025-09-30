package com.university.service;

import com.university.entity.GioHoc;
import com.university.repository.GioHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GioHocService {

    @Autowired
    private GioHocRepository gioHocRepository;

    public List<GioHoc> findAll() {
        return gioHocRepository.findAll();
    }

    public Optional<GioHoc> findById(UUID id) {
        return gioHocRepository.findById(id);
    }

    public GioHoc save(GioHoc gioHoc) {
        return gioHocRepository.save(gioHoc);
    }

    public void deleteById(UUID id) {
        gioHocRepository.deleteById(id);
    }

    public boolean existsByMaGioHoc(String maGioHoc) {
        return gioHocRepository.existsByMaGioHoc(maGioHoc);
    }
}
