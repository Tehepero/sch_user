package com.sparta.sch_user.service;

import com.sparta.sch_user.dto.ScheduleRequestDto;
import com.sparta.sch_user.dto.ScheduleResponseDto;
import com.sparta.sch_user.dto.ScheduleUpdateRequestDto;
import com.sparta.sch_user.entity.Schedule;
import com.sparta.sch_user.entity.User;
import com.sparta.sch_user.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserService userService;

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        return schedules
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleResponseDto findById(Long id) {
        return ScheduleResponseDto.toDto(findScheduleById(id));

    }

    private Schedule findScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 ID 값 입니다."));
    }

    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        User user = userService.findUserById(requestDto.getUserId());
        Schedule schedule = new Schedule(user, requestDto.getTitle(), requestDto.getDescription());

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return ScheduleResponseDto.toDto(savedSchedule);
    }

    @Transactional
    public void deleteSchedule(Long id) {
        findScheduleById(id);
        scheduleRepository.deleteById(id);
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleUpdateRequestDto scheduleRequestDto) {
        Schedule schedule = findScheduleById(id);
        schedule.update(scheduleRequestDto.getTitle(), scheduleRequestDto.getDescription());
        return ScheduleResponseDto.toDto(schedule);
    }
}
