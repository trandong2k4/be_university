package com.university.service;

import com.university.entity.PhongHoc;
import com.university.repository.PhongHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhongHocService {

    @Autowired
    private PhongHocRepository phongHocRepository;

    public List<PhongHoc> findAll() {
        return phongHocRepository.findAll();
    }

    public Optional<PhongHoc> findById(UUID id) {
        return phongHocRepository.findById(id);
    }

    public PhongHoc save(PhongHoc phongHoc) {
        return phongHocRepository.save(phongHoc);
    }

    public void deleteById(UUID id) {
        phongHocRepository.deleteById(id);
    }

    public boolean existsByMaPhongHoc(String maPhongHoc) {
        return phongHocRepository.existsByMaPhongHoc(maPhongHoc);
    }
}
