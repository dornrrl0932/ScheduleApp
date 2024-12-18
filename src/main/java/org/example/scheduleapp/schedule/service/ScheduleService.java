package org.example.scheduleapp.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduleapp.schedule.dto.TodoCreateRequestDto;
import org.example.scheduleapp.schedule.dto.TodoResponseDto;
import org.example.scheduleapp.schedule.entity.Schedule;
import org.example.scheduleapp.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    //속성
    private final ScheduleRepository scheduleRepository;


    //기능

    /*
    할일 생성
     */
    public TodoResponseDto createTodo(TodoCreateRequestDto requestDto) {

        //요청으로 받은 제목과 할 일로 schedule(객체) 생성
        Schedule schedule = new Schedule(requestDto.getWriter(), requestDto.getTitle(), requestDto.getWorkTodo());

        //생성한 할일 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new TodoResponseDto(savedSchedule.getId(), savedSchedule.getWriter(), savedSchedule.getTitle(), savedSchedule.getWorkTodo(), savedSchedule.getCreateDateTime());
    }

    /*
    할 일 전체 조회
     */
    public List<TodoResponseDto> findAllTodo() {

        //findAll을 통해 조회, list 형태의 findAllTodo에 저장
        List<Schedule> findAllTodo = scheduleRepository.findAll();

        //findAllTodo을 TodoResponseDto로 변환
        List<TodoResponseDto> todoResponseDtos = findAllTodo.stream()
                .map(schedule -> new TodoResponseDto(
                        schedule.getId(),
                        schedule.getWriter(),
                        schedule.getTitle(),
                        schedule.getWorkTodo(),
                        schedule.getCreateDateTime()))
                .collect(Collectors.toList());

        // 변환된 List<TodoResponseDto> 반환
        return todoResponseDtos;
    }

    /*
    할 일 단건 조회
     */
    public TodoResponseDto findById(Long id) {

        Schedule idOrElseThrow = scheduleRepository.findByIdOrElseThrow(id);

        return new TodoResponseDto(idOrElseThrow.getId(), idOrElseThrow.getWriter(), idOrElseThrow.getTitle(), idOrElseThrow.getWorkTodo(), idOrElseThrow.getCreateDateTime());
    }

    public void deleteTodo(Long id) {

        scheduleRepository.deleteById(id);
    }
}


