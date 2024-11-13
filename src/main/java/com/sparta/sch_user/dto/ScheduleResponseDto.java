package com.sparta.sch_user.dto;

import com.sparta.sch_user.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String writerName;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleResponseDto(Long id, String writerName, String title, String description, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.writerName = writerName;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getWriterName(),
                schedule.getTitle(),
                schedule.getDescription(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );

    }
}
