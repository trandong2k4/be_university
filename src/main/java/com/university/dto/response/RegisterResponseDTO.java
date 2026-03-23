package com.university.dto.response;

import java.sql.Time;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDTO {
    private UUID id;
    private String username;
    private Time createDate;

    public RegisterResponseDTO(UUID id, String username, String fullName, Time cDate) {
        this.id = id;
        this.username = username;
        this.createDate = cDate;
    }
}
