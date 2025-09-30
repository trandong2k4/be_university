package com.university.service;

import com.university.entity.LoaiTinChi;
import com.university.repository.LoaiTinChiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoaiTinChiService {

    @Autowired
    private LoaiTinChiRepository loaiTinChiRepository;

    public List<LoaiTinChi> findAll() {
        return loaiTinChiRepository.findAll();
    }

    public Optional<LoaiTinChi> findById(UUID id) {
        return loaiTinChiRepository.findById(id);
    }

    public LoaiTinChi save(LoaiTinChi loaiTinChi) {
        return loaiTinChiRepository.save(loaiTinChi);
    }

    public void deleteById(UUID id) {
        loaiTinChiRepository.deleteById(id);
    }

    public boolean existsByMaLoaiTinChi(String maLoaiTinChi) {
        return loaiTinChiRepository.existsByMaLoaiTinChi(maLoaiTinChi);
    }
}
