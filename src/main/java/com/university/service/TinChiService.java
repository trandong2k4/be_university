package com.university.service;

import com.university.entity.TinChi;
import com.university.repository.TinChiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TinChiService {

    @Autowired
    private TinChiRepository tinChiRepository;

    public List<TinChi> findAll() {
        return tinChiRepository.findAll();
    }

    public Optional<TinChi> findById(UUID id) {
        return tinChiRepository.findById(id);
    }

    public TinChi save(TinChi tinChi) {
        return tinChiRepository.save(tinChi);
    }

    public void deleteById(UUID id) {
        tinChiRepository.deleteById(id);
    }
}
