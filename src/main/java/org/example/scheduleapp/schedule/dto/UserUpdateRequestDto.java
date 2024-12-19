package org.example.scheduleapp.schedule.dto;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private final String userName;
    private final String email;

    public UserUpdateRequestDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
