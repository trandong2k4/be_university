package com.university.service;

import com.university.entity.SinhVien;
import com.university.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    public List<SinhVien> findAll() { return sinhVienRepository.findAll(); }

    public Optional<SinhVien> findById(UUID id) { return sinhVienRepository.findById(id); }

    public SinhVien save(SinhVien sinhVien) { return sinhVienRepository.save(sinhVien); }

    public void deleteById(UUID id) { sinhVienRepository.deleteById(id); }

    public boolean existsByMaSinhVien(String maSinhVien) { return sinhVienRepository.existsByMaSinhVien(maSinhVien); }
}
