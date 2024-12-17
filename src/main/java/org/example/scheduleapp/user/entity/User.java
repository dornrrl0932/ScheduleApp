package org.example.scheduleapp.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;


@Getter
@Entity //데이터 베이스 테이블과 매핑, JPA Entity임을 선언
@EntityListeners(AutoCloseable.class) // 자동으로 날짜를 기록
public class User {

    @Id // 해당 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 기본 키 값이 증가하도록 설정
    private Long id;

    private String userName;

    private String email;

    @CreatedDate //생성된 날짜를 자동으로 기록
    @Column(updatable = false) //데이터베이스에 저장한 후 값이 변경되지 않음
    private LocalDateTime createDateTime;

    private Long password;
}
