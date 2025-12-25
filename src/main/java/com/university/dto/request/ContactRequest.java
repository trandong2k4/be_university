package com.university.dto.request;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private String email;
    private String soDienThoai;
    private String diaChi;
    private String facebook;
    private String tiktok;
    private UUID truongId;
}
