package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReponse {
    private UUID id;
    private String username;
    private LocalDate createDate;

    public RegisterReponse(UUID id, String username, String fullName, LocalDate cDate) {
        this.id = id;
        this.username = username;
        this.createDate = cDate;
    }
}
