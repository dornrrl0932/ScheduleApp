package org.example.scheduleapp.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduleapp.schedule.dto.SignUpRequestDto;
import org.example.scheduleapp.schedule.dto.SignUpResponseDto;
import org.example.scheduleapp.schedule.entity.User;
import org.example.scheduleapp.schedule.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /*
    회원 생성
     */
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        
        //요청 받은 데이터로 유저 생성
        User user = new User(signUpRequestDto.getUserName(), signUpRequestDto.getEmail(), signUpRequestDto.getPassword());

        //생성한 유저 저장하기
        User savedUser = userRepository.save(user);

        //SignUpResponseDto 형태로 응답하기
        return new SignUpResponseDto(savedUser.getUserName(),savedUser.getEmail(),savedUser.getCreateDateTime());
    }
}
