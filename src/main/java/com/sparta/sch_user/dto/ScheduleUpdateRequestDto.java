package com.sparta.sch_user.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {
    private final String title;
    private final String description;

    public ScheduleUpdateRequestDto(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
