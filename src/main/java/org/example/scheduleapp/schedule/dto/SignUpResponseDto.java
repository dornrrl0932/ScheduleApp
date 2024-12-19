package org.example.scheduleapp.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignUpResponseDto {

    private final String username;

    private final String email;

    private final LocalDateTime createDateTime;

    public SignUpResponseDto(String username, String email, LocalDateTime createDateTime) {
        this.username = username;
        this.email = email;
        this.createDateTime = createDateTime;
    }
}
