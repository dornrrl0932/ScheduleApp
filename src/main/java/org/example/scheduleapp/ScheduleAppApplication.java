package org.example.scheduleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing을 사용하기 위해 애플리케이션 클래스 상단에 선언
@SpringBootApplication
public class ScheduleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleAppApplication.class, args);
    }

}
