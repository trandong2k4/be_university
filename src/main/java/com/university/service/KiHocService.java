package com.university.service;

import com.university.entity.KiHoc;
import com.university.repository.KiHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KiHocService {

    @Autowired
    private KiHocRepository kiHocRepository;

    public List<KiHoc> findAll() {
        return kiHocRepository.findAll();
    }

    public Optional<KiHoc> findById(UUID id) {
        return kiHocRepository.findById(id);
    }

    public KiHoc save(KiHoc kiHoc) {
        return kiHocRepository.save(kiHoc);
    }

    public void deleteById(UUID id) {
        kiHocRepository.deleteById(id);
    }

    public boolean existsByMaKiHoc(String maKiHoc) {
        return kiHocRepository.existsByMaKiHoc(maKiHoc);
    }
}
