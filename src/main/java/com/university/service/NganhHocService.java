package com.university.service;

import com.university.entity.NganhHoc;
import com.university.repository.NganhHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NganhHocService {

    @Autowired
    private NganhHocRepository nganhHocRepository;

    public List<NganhHoc> findAll() {
        return nganhHocRepository.findAll();
    }

    public Optional<NganhHoc> findById(UUID id) {
        return nganhHocRepository.findById(id);
    }

    public NganhHoc save(NganhHoc nganhHoc) {
        return nganhHocRepository.save(nganhHoc);
    }

    public void deleteById(UUID id) {
        nganhHocRepository.deleteById(id);
    }

    public boolean existsByMaNganh(String maNganh) {
        return nganhHocRepository.existsByMaNganh(maNganh);
    }
}
