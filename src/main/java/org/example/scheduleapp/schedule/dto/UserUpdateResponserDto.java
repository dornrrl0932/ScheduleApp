package org.example.scheduleapp.schedule.dto;

import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class UserUpdateResponserDto {

    private final Long id;
    private final String userName;
    private final String email;

    public UserUpdateResponserDto(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
