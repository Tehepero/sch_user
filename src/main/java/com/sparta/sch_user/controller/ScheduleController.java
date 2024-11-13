package com.sparta.sch_user.controller;

import com.sparta.sch_user.dto.ScheduleRequestDto;
import com.sparta.sch_user.dto.ScheduleResponseDto;
import com.sparta.sch_user.dto.ScheduleUpdateRequestDto;
import com.sparta.sch_user.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        return ResponseEntity.ok().body(scheduleService.findAll());
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok().body(scheduleService.findById(id));
    }

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createSchedule(scheduleRequestDto));
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok().body("정상적으로 삭제되었습니다.");
    }

    @PatchMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@RequestBody ScheduleUpdateRequestDto scheduleRequestDto,
                                                              @PathVariable Long id) {
        return ResponseEntity.ok().body(scheduleService.update(id, scheduleRequestDto));
    }
}
