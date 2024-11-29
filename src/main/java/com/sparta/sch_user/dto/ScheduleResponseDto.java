package com.sparta.sch_user.dto;  // DTO 패키지. 클라이언트와 서버 간 데이터 주고받을 때 사용하는 객체들 모음

import com.sparta.sch_user.entity.Schedule;  // Schedule 엔티티 클래스를 import. 이 객체를 기반으로 DTO를 만들 거니까
import lombok.Getter;  // Lombok의 @Getter 어노테이션. 이 클래스의 필드들에 대한 getter 메서드를 자동으로 만들어줘.

import java.time.LocalDateTime;  // 날짜와 시간을 다루는 LocalDateTime 클래스, 생성일자와 수정일자 관리할 때 사용

@Getter  // 이 어노테이션이 있으면 해당 클래스의 필드들에 대해 getter 메서드가 자동으로 생성돼
public class ScheduleResponseDto {  // 스케줄 조회할 때 클라이언트로 보낼 응답 데이터를 담는 DTO 클래스

    private final Long id;  // 스케줄 고유 ID
    private final Long userId;  // 이 스케줄을 작성한 사용자의 ID
    private final String title;  // 스케줄 제목
    private final String description;  // 스케줄 설명
    private final LocalDateTime createdAt;  // 스케줄 생성 시간
    private final LocalDateTime modifiedAt;  // 스케줄 수정 시간

    // 생성자. Schedule 객체를 받아서 해당 객체의 정보를 이 DTO에 담아서 초기화
    public ScheduleResponseDto(Long id, Long userId, String title, String description, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;  // id 값 초기화
        this.userId = userId;  // userId 값 초기화
        this.title = title;  // title 값 초기화
        this.description = description;  // description 값 초기화
        this.createdAt = createdAt;  // createdAt 값 초기화
        this.modifiedAt = modifiedAt;  // modifiedAt 값 초기화
    }

    // Schedule 엔티티 객체를 받아서, 그 객체의 필드 값을 이용해 이 DTO 객체를 만들어주는 메서드
    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getId(),  // Schedule 엔티티에서 id 값 가져오기
                schedule.getUser().getId(),  // Schedule 엔티티에서 userId 가져오기
                schedule.getTitle(),  // Schedule 엔티티에서 title 가져오기
                schedule.getDescription(),  // Schedule 엔티티에서 description 가져오기
                schedule.getCreatedAt(),  // Schedule 엔티티에서 createdAt 가져오기
                schedule.getModifiedAt()  // Schedule 엔티티에서 modifiedAt 가져오기
        );
    }
}
