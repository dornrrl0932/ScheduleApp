package org.example.scheduleapp.schedule.dto;

import lombok.Getter;

/*
회원가입 시 요청받을 데이터
 */
@Getter
public class SignUpRequestDto {

    private final String username;
    private final String email;
    private final Long password;

    public SignUpRequestDto(String username, String email, Long password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
