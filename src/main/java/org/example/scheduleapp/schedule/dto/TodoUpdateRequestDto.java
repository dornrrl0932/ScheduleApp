package org.example.scheduleapp.schedule.dto;

import lombok.Getter;

/*
일정 수정 시 요청받을 데이터
 */
@Getter
public class TodoUpdateRequestDto {

    private final String title;
    private final String workTodo;

    public TodoUpdateRequestDto(String title, String workTodo) {
        this.title = title;
        this.workTodo = workTodo;
    }
}


