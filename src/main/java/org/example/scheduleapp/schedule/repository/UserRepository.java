package org.example.scheduleapp.schedule.repository;

import org.example.scheduleapp.schedule.entity.Schedule;
import org.example.scheduleapp.schedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
