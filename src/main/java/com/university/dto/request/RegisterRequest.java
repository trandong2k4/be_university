package com.university.dto.request;

import java.time.LocalDate;
import com.university.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private LocalDate createDate;

    public RegisterRequest(String username, String password, LocalDate createDate,
            Role role) {
        this.username = username;
        this.password = password;
        this.createDate = createDate;
    }
}
