package org.example.scheduleapp.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/*
할 일 생성 완료 시 응답할 데이터
 */
@Getter
@AllArgsConstructor // 전체 필드를 가진 생성자 추가ㄴ
public class TodoCreateResponseDto {

    private Long id;
    private String writer;
    private String title;
    private String workTodo;
    private LocalDateTime createDateTime;
    private LocalDateTime modifyDateTime;
}
