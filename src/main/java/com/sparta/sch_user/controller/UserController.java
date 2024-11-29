package com.sparta.sch_user.controller;  // 'controller' 패키지에 있는 클래스야. 사용자 관련 API 다루는 곳

import com.sparta.sch_user.dto.LoginRequestDto;  // 로그인 요청 받을 때 사용할 DTO
import com.sparta.sch_user.dto.UserRequestDto;  // 사용자 생성할 때 받을 DTO
import com.sparta.sch_user.dto.UserResponseDto;  // 사용자 응답할 때 사용할 DTO
import com.sparta.sch_user.entity.User;  // User 엔티티, DB랑 연결되는 객체
import com.sparta.sch_user.service.UserService;  // 실제 비즈니스 로직 처리하는 서비스 클래스
import jakarta.servlet.http.HttpServletRequest;  // HTTP 요청을 처리하는 클래스
import jakarta.servlet.http.HttpSession;  // 세션 처리하는 클래스
import lombok.RequiredArgsConstructor;  // 자동으로 생성자 주입해주는 Lombok 어노테이션
import org.springframework.http.HttpStatus;  // HTTP 상태 코드들 정의하는 클래스
import org.springframework.http.ResponseEntity;  // 응답을 커스터마이즈해서 반환하는 클래스
import org.springframework.web.bind.annotation.*;  // REST API를 위한 어노테이션들

import java.util.List;  // 여러 사용자 목록 반환할 때 쓰는 List

@RestController  // 이 클래스가 REST API를 처리하는 컨트롤러임을 선언하는 어노테이션
@RequestMapping("/users")  // '/users' 경로로 들어오는 요청을 이 클래스에서 처리함
@RequiredArgsConstructor  // Lombok이 자동으로 의존성 주입 해줌
public class UserController {  // UserController 클래스 시작. 사용자 관련 요청 처리

    private final UserService userService;  // UserService 클래스 의존성 주입. 서비스에서 실제 로직 처리함.

    @GetMapping  // GET 요청으로 '/users'로 들어오면 호출되는 메서드
    public ResponseEntity<List<UserResponseDto>> findAll() {  // 모든 사용자 목록을 가져오는 메서드
        return ResponseEntity.ok().body(userService.findAll());  // 서비스에서 사용자 목록 가져와서 반환
    }

    @PostMapping  // POST 요청으로 '/users'로 들어오면 호출되는 메서드. 새로운 사용자 생성
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        // 요청 본문에 담긴 데이터(UserRequestDto)로 사용자 생성
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequestDto));
        // 사용자 생성 후, 201 Created 상태 코드와 함께 새로 생성된 사용자 반환
    }

    @DeleteMapping("/{id}")  // DELETE 요청으로 '/users/{id}'로 들어오면 해당 id의 사용자 삭제
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {  // id로 사용자 삭제하는 메서드
        userService.deleteUser(id);  // 서비스에서 해당 id로 사용자 삭제
        return ResponseEntity.ok().body("정상적으로 삭제되었습니다.");  // 삭제 완료 메시지 반환
    }

    @PostMapping("/login")  // '/users/login' 경로로 들어오는 POST 요청 처리. 로그인 관련
    public ResponseEntity<String> loginUser(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
        // 로그인 요청 본문 데이터를 LoginRequestDto로 받고, HttpServletRequest로 세션 처리
        User loginedUser = userService.loginUser(loginRequestDto);  // 로그인 로직 처리해서 로그인한 사용자 객체 반환
        HttpSession session = request.getSession();  // 세션 가져오기
        session.setAttribute("SESSION_KEY", loginedUser.getId());  // 세션에 사용자 ID 저장

        return ResponseEntity.ok().body("정상적으로 로그인되었습니다.");  // 로그인 성공 메시지 반환
    }

    @PostMapping("/logout")  // '/users/logout' 경로로 들어오는 POST 요청 처리. 로그아웃 관련
    public ResponseEntity<String> logout(HttpServletRequest request) {  // 로그아웃 처리하는 메서드
        HttpSession session = request.getSession(false);  // 세션이 있으면 가져오고 없으면 null 반환
        if (session != null) {
            session.invalidate();  // 세션 무효화, 즉 로그아웃 처리
        }
        return ResponseEntity.ok("로그아웃 성공");  // 로그아웃 성공 메시지 반환
    }
}
