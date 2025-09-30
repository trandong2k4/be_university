package com.university.service;

import com.university.entity.Khoa;
import com.university.repository.KhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhoaService {

    @Autowired
    private KhoaRepository khoaRepository;

    public List<Khoa> findAll() {
        return khoaRepository.findAll();
    }

    public Optional<Khoa> findById(UUID id) {
        return khoaRepository.findById(id);
    }

    public Khoa save(Khoa khoa) {
        return khoaRepository.save(khoa);
    }

    public void deleteById(UUID id) {
        khoaRepository.deleteById(id);
    }

    public boolean existsByMaKhoa(String maKhoa) {
        return khoaRepository.existsByMaKhoa(maKhoa);
    }
}
