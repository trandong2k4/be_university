package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.request.ContactRequest;
import com.university.dto.response.ContactResponseDTO;
import com.university.entity.LienHe;
import com.university.entity.Truong;
import com.university.repository.TruongRepository;

@Component
public class ContactMapper {
    TruongRepository truongRepository;

    public LienHe toEntity(ContactRequest dto) {
        Truong truong = truongRepository.findById(dto.getTruongId())
                .orElseThrow(() -> new RuntimeException("Truong not found"));
        return LienHe.builder()
                .email(dto.getEmail())
                .soDienThoai(dto.getSoDienThoai())
                .diaChi(dto.getDiaChi())
                .facebook(dto.getFacebook())
                .tiktok(dto.getTiktok())
                .truong(truong)
                .build();
    }

    public ContactResponseDTO toResponseDTO(LienHe dto) {
        return ContactResponseDTO.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .soDienThoai(dto.getSoDienThoai())
                .diaChi(dto.getDiaChi())
                .facebook(dto.getFacebook())
                .tiktok(dto.getTiktok())
                .tenTruong(dto.getTruong().getTenTruong())
                .build();
    }
}
