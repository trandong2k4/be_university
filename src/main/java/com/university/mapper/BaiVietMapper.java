package com.university.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.BaiVietResponse;
import com.university.dto.request.BaiVietRequest;
import com.university.entity.BaiViet;
import com.university.entity.User;

@Component
public class BaiVietMapper {

    public BaiViet toEntity(BaiVietRequest dto, User user) {
        BaiViet entity = new BaiViet();
        entity.setTieuDe(dto.getTieuDe());
        entity.setNoiDung(dto.getNoiDung());
        entity.setLoaiBaiViet(dto.getLoaiBaiViet());
        entity.setNgayDang(dto.getNgayDang() != null ? dto.getNgayDang() : LocalDate.now());
        entity.setTacGia(dto.getTacGia());
        entity.setTrangThai(dto.getTrangThai() != null ? dto.getTrangThai() : "CONG_KHAI");
        entity.setHinhAnhUrl(dto.getHinhAnhUrl());
        entity.setFileDinhKemUrl(dto.getFileDinhKemUrl());
        entity.setUser(user);
        return entity;
    }

    public void updateEntity(BaiViet entity, BaiVietRequest dto, User user) {
        entity.setTieuDe(dto.getTieuDe());
        entity.setNoiDung(dto.getNoiDung());
        entity.setLoaiBaiViet(dto.getLoaiBaiViet());
        entity.setNgayDang(dto.getNgayDang());
        entity.setTacGia(dto.getTacGia());
        entity.setTrangThai(dto.getTrangThai());
        entity.setHinhAnhUrl(dto.getHinhAnhUrl());
        entity.setFileDinhKemUrl(dto.getFileDinhKemUrl());
        entity.setUser(user);
    }

    public BaiVietResponse toResponse(BaiViet entity) {
        BaiVietResponse response = new BaiVietResponse();
        response.setId(entity.getId());
        response.setTieuDe(entity.getTieuDe());
        response.setNoiDung(entity.getNoiDung());
        response.setLoaiBaiViet(entity.getLoaiBaiViet());
        response.setNgayDang(entity.getNgayDang());
        response.setTacGia(entity.getTacGia());
        response.setTrangThai(entity.getTrangThai());
        response.setHinhAnhUrl(entity.getHinhAnhUrl());
        response.setFileDinhKemUrl(entity.getFileDinhKemUrl());
        response.setTenNguoiDang(
                entity.getUser() != null ? entity.getUser().getFirstName() + entity.getUser().getLastName() : null);
        return response;
    }
}