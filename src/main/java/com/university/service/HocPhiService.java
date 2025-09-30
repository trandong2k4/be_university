package com.university.service;

import com.university.entity.HocPhi;
import com.university.repository.HocPhiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HocPhiService {

    @Autowired
    private HocPhiRepository hocPhiRepository;

    public List<HocPhi> findAll() {
        return hocPhiRepository.findAll();
    }

    public Optional<HocPhi> findById(UUID id) {
        return hocPhiRepository.findById(id);
    }

    public HocPhi save(HocPhi hocPhi) {
        return hocPhiRepository.save(hocPhi);
    }

    public void deleteById(UUID id) {
        hocPhiRepository.deleteById(id);
    }
}
