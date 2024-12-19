package org.example.scheduleapp.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignUpResponseDto {

    private final Long id;
    private final String userName;
    private final String email;
    private final LocalDateTime createDateTime;

    public SignUpResponseDto(Long id, String userName, String email, LocalDateTime createDateTime) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.createDateTime = createDateTime;
    }
}
