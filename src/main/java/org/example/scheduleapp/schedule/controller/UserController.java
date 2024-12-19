package org.example.scheduleapp.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduleapp.schedule.dto.SignUpRequestDto;
import org.example.scheduleapp.schedule.dto.SignUpResponseDto;
import org.example.scheduleapp.schedule.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*
    회원 생성
     */
    @PostMapping
    public ResponseEntity<SignUpResponseDto> signUp (@RequestBody SignUpRequestDto signUpRequestDto) {

        SignUpResponseDto signUpResponseDto = userService.signUp(signUpRequestDto);

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }
}
