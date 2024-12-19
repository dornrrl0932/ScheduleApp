package org.example.scheduleapp.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduleapp.schedule.dto.SignUpRequestDto;
import org.example.scheduleapp.schedule.dto.SignUpResponseDto;
import org.example.scheduleapp.schedule.dto.UserResponseDto;
import org.example.scheduleapp.schedule.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*
    회원 생성
     */
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp (@RequestBody SignUpRequestDto signUpRequestDto) {

        SignUpResponseDto signUpResponseDto = userService.signUp(signUpRequestDto);

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    /*
    회원 조회
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> findUser (@PathVariable Long id) {

        UserResponseDto userResponseDto = userService.findUser(id);

        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    /*
    회원 삭제
     */
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> DeleteUser (@PathVariable Long id) {

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
