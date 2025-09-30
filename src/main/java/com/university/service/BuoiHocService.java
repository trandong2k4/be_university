package com.university.service;

import com.university.entity.BuoiHoc;
import com.university.repository.BuoiHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BuoiHocService {

    @Autowired
    private BuoiHocRepository buoiHocRepository;

    public List<BuoiHoc> findAll() {
        return buoiHocRepository.findAll();
    }

    public Optional<BuoiHoc> findById(UUID id) {
        return buoiHocRepository.findById(id);
    }

    public BuoiHoc save(BuoiHoc buoiHoc) {
        return buoiHocRepository.save(buoiHoc);
    }

    public void deleteById(UUID id) {
        buoiHocRepository.deleteById(id);
    }
}
