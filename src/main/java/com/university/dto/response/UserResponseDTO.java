package com.university.dto.response;

import java.sql.Time;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDTO {
    private UUID id;
    private String email;
    private String username;
    private boolean status;
    private String note;
    private Time createDate;
    private Time updateDate;
    private UUID roleId;

    public interface UserView {
        UUID getId();

        String getUsername();

        String getEmail();

        boolean isStatus();

        String getNote();

        Time getCreateDate();

        Time getUpdateDate();

        UUID getRoleId();
    }
}