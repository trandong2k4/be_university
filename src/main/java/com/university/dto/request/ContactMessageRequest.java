package com.university.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactMessageRequest {
    private String name;
    private String email;
    private String message;
}
