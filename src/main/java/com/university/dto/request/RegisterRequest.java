package com.university.dto.request;

import java.sql.Time;
import com.university.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String username;

    private String password;

    private Time createDate;

    public RegisterRequest(String username, String password, Time createDate,
            Role role) {
        this.username = username;
        this.password = password;
        this.createDate = createDate;
    }
}
