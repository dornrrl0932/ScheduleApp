package org.example.scheduleapp.schedule.controller;

import org.example.scheduleapp.schedule.dto.TodoCreateRequestDto;
import org.example.scheduleapp.schedule.dto.TodoCreateResponseDto;
import org.example.scheduleapp.schedule.servise.ScheduleServise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class ScheduleController {

    //속성
    private final ScheduleServise scheduleServise;

    /*
    생성자
    ScheduleServise 사용하기 위한 생성자 주입
     */
    public ScheduleController(ScheduleServise scheduleServise) {
        this.scheduleServise = scheduleServise;
    }

    //기능

    /*
    할 일 생성
     */
    @PostMapping
    public ResponseEntity<TodoCreateRequestDto>createTodo (@RequestBody TodoCreateRequestDto requestDto) {

        return new ResponseEntity<>(scheduleServise.createTodo(requestDto), HttpStatus.CREATED);
    }
}
