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

    private String title;
    private String workTodo;

}
