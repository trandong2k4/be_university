package com.university.service;

import com.university.entity.NhanVien;
import com.university.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    public Optional<NhanVien> findById(UUID id) {
        return nhanVienRepository.findById(id);
    }

    public NhanVien save(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public void deleteById(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return nhanVienRepository.existsByEmail(email);
    }
}
