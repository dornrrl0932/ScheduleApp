package org.example.scheduleapp.schedule.controller;

import org.example.scheduleapp.schedule.dto.TodoCreateRequestDto;
import org.example.scheduleapp.schedule.dto.TodoResponseDto;
import org.example.scheduleapp.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ScheduleController {

    //속성
    private final ScheduleService scheduleService;

    /*
    생성자
    ScheduleServise 사용하기 위한 생성자 주입
     */
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //기능

    /*
    할 일 생성
     */
    @PostMapping
    public ResponseEntity<TodoResponseDto>createTodo(@RequestBody TodoCreateRequestDto requestDto) {

        TodoResponseDto todoResponseDto = scheduleService.createTodo(requestDto);

        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }


    /*
    할 일 전체 조회
     */
    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAllTodo() {

        //scheduleService.findAllTodo를 호출 -> 응답 데이터(할 일)를 모아놓은 리스트를 전달
        List<TodoResponseDto> todoResponseDtoList = scheduleService.findAllTodo();

        return new ResponseEntity<>(todoResponseDtoList,HttpStatus.OK);
    }

//    /*
//    할 일 단건 조회
//     */
//    @GetMapping("/id/{id}")
//    public ResponseEntity<TodoResponseDto> findById (@PathVariable Long id) {
//
//        TodoResponseDto todoResponseDto = scheduleService.findById(id);
//
//        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
//    }
}
