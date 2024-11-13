package com.sparta.sch_user.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private final String writerName;
    private final String title;
    private final String description;

    public ScheduleRequestDto(String writerName, String title, String description) {
        this.writerName = writerName;
        this.title = title;
        this.description = description;
    }
}
