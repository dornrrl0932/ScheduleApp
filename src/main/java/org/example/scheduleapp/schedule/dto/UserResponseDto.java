package org.example.scheduleapp.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private final String userName;
    private final String email;
    private final LocalDateTime createDateTime;

    public UserResponseDto(String userName, String email, LocalDateTime createDateTime) {
        this.userName = userName;
        this.email = email;
        this.createDateTime = createDateTime;
    }
}

