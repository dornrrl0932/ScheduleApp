package org.example.scheduleapp.schedule.dto;

import lombok.Getter;

/*
회원가입 시 요청받을 데이터
 */
@Getter
public class SignUpRequestDto {

    private final String userName;
    private final String email;
    private final Long password;

    public SignUpRequestDto(String userName, String email, Long password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
