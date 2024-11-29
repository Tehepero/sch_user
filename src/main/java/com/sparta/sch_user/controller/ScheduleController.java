package com.sparta.sch_user.controller;  // 여기선 스케줄 관련 API를 처리하는 컨트롤러임

import com.sparta.sch_user.dto.ScheduleRequestDto;  // 스케줄 만들 때 받을 DTO임
import com.sparta.sch_user.dto.ScheduleResponseDto;  // 스케줄 정보를 클라이언트에 반환할 DTO임
import com.sparta.sch_user.dto.ScheduleUpdateRequestDto;  // 스케줄 수정할 때 받을 DTO임
import com.sparta.sch_user.service.ScheduleService;  // 비즈니스 로직 처리하는 서비스 클래스임
import lombok.RequiredArgsConstructor;  // 생성자 자동 주입해주는 Lombok 어노테이션
import org.springframework.http.HttpStatus;  // HTTP 상태 코드 관련 클래스
import org.springframework.http.ResponseEntity;  // HTTP 응답을 만들 때 사용하는 클래스
import org.springframework.web.bind.annotation.*;  // REST API 관련 어노테이션들

import java.util.List;  // 여러 스케줄을 반환할 때 List 사용함

@RestController  // 이 클래스가 REST API를 처리하는 컨트롤러임을 표시하는 어노테이션임
@RequiredArgsConstructor  // Lombok으로 생성자 자동 주입되도록 해주는 어노테이션임
public class ScheduleController {  // 스케줄 관련 요청을 처리하는 컨트롤러 시작!

    private final ScheduleService scheduleService;  // ScheduleService는 스케줄 관련 로직 처리하는 곳임. 의존성 주입함.

    @GetMapping("/schedules")  // GET 요청이 /schedules로 오면 호출됨
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {  // 모든 스케줄을 찾아서 반환하는 메서드
        return ResponseEntity.ok().body(scheduleService.findAll());  // 모든 스케줄을 서비스에서 가져와서 반환
    }

    @GetMapping("/schedules/{id}")  // /schedules/{id}로 GET 요청 오면, id에 해당하는 스케줄 하나 반환
    public ResponseEntity<ScheduleResponseDto> findOne(@PathVariable Long id) {  // id로 스케줄 하나 찾아서 반환
        return ResponseEntity.ok().body(scheduleService.findById(id));  // 해당 id로 스케줄을 찾아서 응답
    }

    @PostMapping("/schedules")  // /schedules로 POST 요청 오면, 새로운 스케줄을 생성함
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        // 요청 본문에 담긴 데이터를 ScheduleRequestDto로 받아서 처리
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createSchedule(scheduleRequestDto));
        // 스케줄을 성공적으로 생성한 후, 201 상태 코드와 함께 응답
    }

    @DeleteMapping("/schedules/{id}")  // /schedules/{id}로 DELETE 요청 오면 해당 스케줄 삭제
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {  // id에 해당하는 스케줄을 삭제하는 메서드
        scheduleService.deleteSchedule(id);  // 서비스에서 해당 id의 스케줄 삭제
        return ResponseEntity.ok().body("정상적으로 삭제되었습니다.");  // 삭제 완료 메시지 반환
    }

    @PatchMapping("/schedules/{id}")  // /schedules/{id}로 PATCH 요청 오면 해당 스케줄 업데이트
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@RequestBody ScheduleUpdateRequestDto scheduleRequestDto,
                                                              @PathVariable Long id) {
        // 요청 본문에 담긴 데이터를 ScheduleUpdateRequestDto로 받아서 업데이트 처리
        return ResponseEntity.ok().body(scheduleService.update(id, scheduleRequestDto));
        // 업데이트된 스케줄을 반환
    }
}
