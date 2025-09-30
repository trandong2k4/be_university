package com.university.service;

import com.university.entity.ViTri;
import com.university.repository.VitriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VitriService {

    @Autowired
    private VitriRepository vitriRepository;

    public List<ViTri> findAll() {
        return vitriRepository.findAll();
    }

    public Optional<ViTri> findById(UUID id) {
        return vitriRepository.findById(id);
    }

    public ViTri save(ViTri vitri) {
        return vitriRepository.save(vitri);
    }

    public void deleteById(UUID id) {
        vitriRepository.deleteById(id);
    }

    public boolean existsByMaViTri(String maViTri) {
        return vitriRepository.existsByMaViTri(maViTri);
    }
}
