package org.example.scheduleapp.schedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.scheduleapp.user.entity.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//작성 유저명, 할일 제목, 할일 내용, 작성일, 수정일
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Schedule {

    @Id //기본 키를 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 기본 키 값이 증가하도록 설정
    private Long id;

    private String writer;

    @Column(nullable = false) //반드시 값을 가져야 한다. 필수값!
    private String title;

    private String workTodo;

    @CreatedDate //생성된 시간을 자동 기록
    @Column(updatable = false) // 데이터를 저장한 후 값이 변경되지 않게 만듦
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDateTime;

    @LastModifiedDate //수정된 시간을 자동으로 기록
    private LocalDateTime modifyDateTime;

    @ManyToOne //이 필드는 다대일 관계
    @JoinColumn(name = "user_id")
    private User user;

    //엔티티는 기본 생성자를 필수로 가져야 한다.
    public Schedule () {

    }

    public Schedule (String writer, String title, String workTodo) {
        this.writer = writer;
        this.title = title;
        this.workTodo = workTodo;
    }

    public void updateTodo (String title, String workTodo){
        this.title = title;
        this.workTodo = workTodo;
    }

}
