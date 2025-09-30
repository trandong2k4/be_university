package com.university.service;

import com.university.entity.MonHoc;
import com.university.repository.MonHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MonHocService {

    @Autowired
    private MonHocRepository monHocRepository;

    public List<MonHoc> findAll() {
        return monHocRepository.findAll();
    }

    public Optional<MonHoc> findById(UUID id) {
        return monHocRepository.findById(id);
    }

    public MonHoc save(MonHoc monHoc) {
        return monHocRepository.save(monHoc);
    }

    public void deleteById(UUID id) {
        monHocRepository.deleteById(id);
    }

    public boolean existsByMaMonHoc(String maMonHoc) {
        return monHocRepository.existsByMaMonHoc(maMonHoc);
    }
}
