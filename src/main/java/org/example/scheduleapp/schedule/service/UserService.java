package org.example.scheduleapp.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduleapp.schedule.dto.*;
import org.example.scheduleapp.schedule.entity.User;
import org.example.scheduleapp.schedule.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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
        return new SignUpResponseDto(savedUser.getId(), savedUser.getUserName(), savedUser.getEmail(), savedUser.getCreateDateTime());
    }


    public UserResponseDto findUser(Long id) {

        //id로 유저 조회
        Optional<User> optionalUser = userRepository.findById(id);

        //NPE 방지
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id를 찾을 수 없습니다. :" + id);
        }

        //조회한 유저
        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUserName(), findUser.getEmail(), findUser.getCreateDateTime());
    }

    /*
    회원 수정
     */
    public UserUpdateResponserDto updateUser(Long id, UserUpdateRequestDto userUpdateRequestDto) {

        Optional<User> updateUser = userRepository.findById(id);

        return updateUser
                .map(user -> {
                    user.setUserName(userUpdateRequestDto.getUserName());
                    user.setEmail(userUpdateRequestDto.getEmail());
                    userRepository.save(user);
                    return new UserUpdateResponserDto(user.getId(), user.getUserName(), user.getEmail());
                })
                .orElseThrow(() -> new RuntimeException("ID가 존재하지 않습니다. = " + id));

    }

    /*
    회원 삭제
     */
    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }
}
