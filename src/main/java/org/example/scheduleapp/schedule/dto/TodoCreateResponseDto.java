package org.example.scheduleapp.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/*
할 일 생성 완료 시 응답할 데이터
 */
@Getter
public class TodoCreateResponseDto {

    private final Long id;
    private final String writer;
    private final String title;
    private final String workTodo;
    private final LocalDateTime createDateTime;

    public TodoCreateResponseDto(Long id, String writer, String title, String workTodo, LocalDateTime createDateTime) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.workTodo = workTodo;
        this.createDateTime = createDateTime;
    }
}
