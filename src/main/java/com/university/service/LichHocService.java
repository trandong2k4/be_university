package com.university.service;

import com.university.entity.LichHoc;
import com.university.repository.LichHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LichHocService {

    @Autowired
    private LichHocRepository lichHocRepository;

    public List<LichHoc> findAll() {
        return lichHocRepository.findAll();
    }

    public Optional<LichHoc> findById(UUID id) {
        return lichHocRepository.findById(id);
    }

    public LichHoc save(LichHoc lichHoc) {
        return lichHocRepository.save(lichHoc);
    }

    public void deleteById(UUID id) {
        lichHocRepository.deleteById(id);
    }
}
