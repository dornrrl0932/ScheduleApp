package org.example.scheduleapp.schedule.servise;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.scheduleapp.schedule.dto.TodoCreateRequestDto;
import org.example.scheduleapp.schedule.dto.TodoCreateResponseDto;
import org.example.scheduleapp.schedule.entity.Schedule;
import org.example.scheduleapp.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServise {

    //속성
    private final ScheduleRepository scheduleRepository;


    //기능
    public TodoCreateResponseDto createTodo (TodoCreateRequestDto requestDto) {

        //요청으로 받은 제목과 할 일로 schedule(객체) 생성
        Schedule schedule = new Schedule(requestDto.getWriter(), requestDto.getTitle(), requestDto.getWorkTodo());

        //생성한 할일 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new TodoCreateResponseDto(savedSchedule.getId(), savedSchedule.getWriter(), savedSchedule.getTitle(), savedSchedule.getWorkTodo(), savedSchedule.getCreateDateTime());
    }
}
