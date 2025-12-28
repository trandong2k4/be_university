package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.entity.LichHoc;

@Component
public class LichHocStudentMapper {

    public LichHoc toEntity(LichHoc lichHoc) {
        return lichHoc;
    }

}
