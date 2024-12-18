package org.example.scheduleapp.schedule.repository;

import org.example.scheduleapp.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    /*
    default : 해당 인터페이스를 구현하는 클래스가 이 메서드를 구현하지 않아도 동작할 수 있다.
    리턴타입은 Schedule, id로 할 일(Schedule)을 찾아 반환하거나 그렇지 않으면 예외를 던진다.
     */
    default Schedule findByIdOrElseThrow (Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"ID가 존재하지 않습니다. = " + id));
    }

}
