package com.university.service;

import com.university.entity.Truong;
import com.university.repository.TruongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TruongService {

    @Autowired
    private TruongRepository truongRepository;

    public List<Truong> findAll() {
        return truongRepository.findAll();
    }

    public Optional<Truong> findById(UUID id) {
        return truongRepository.findById(id);
    }

    public Truong save(Truong truong) {
        return truongRepository.save(truong);
    }

    public void deleteById(UUID id) {
        truongRepository.deleteById(id);
    }

    public boolean existsByMaTruong(String maTruong) {
        return truongRepository.existsByMaTruong(maTruong);
    }
}
