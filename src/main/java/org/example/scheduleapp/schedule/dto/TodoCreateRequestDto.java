package org.example.scheduleapp.schedule.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/*
할 일 생성 시 요청받을 데이터
 */
@Getter
public class TodoCreateRequestDto {

    private String writer;
    private final String title;
    private final String workTodo;

    public TodoCreateRequestDto(String writer, String title, String workTodo) {
        this.writer = writer;
        this.title = title;
        this.workTodo = workTodo;
    }
}
