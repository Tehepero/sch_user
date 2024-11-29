package com.sparta.sch_user.dto;  // DTO 패키지, 데이터를 주고받을 때 사용되는 객체들이 들어있는 곳

import lombok.Getter;  // Lombok의 @Getter 어노테이션을 사용해서 필드에 대한 getter 메서드를 자동으로 생성하는 거야

@Getter  // 이 어노테이션을 클래스에 달면, 해당 클래스의 필드에 대해 getter 메서드가 자동으로 만들어짐
public class ScheduleRequestDto {  // 스케줄을 생성할 때 클라이언트가 보낸 데이터를 받을 DTO 클래스야.

    private final Long userId;  // 스케줄을 작성한 사용자의 ID, 해당 사용자를 식별하기 위해 필요함
    private final String title;  // 스케줄의 제목, 사용자에게 보여줄 내용 중 하나
    private final String description;  // 스케줄의 설명, 제목만으론 부족할 때 추가 설명을 담기 위해 사용

    // 생성자, 이 클래스의 객체가 생성될 때 userId, title, description을 받아서 초기화하는 역할
    public ScheduleRequestDto(Long userId, String title, String description) {
        this.userId = userId;  // userId 필드에 받은 userId 값 저장
        this.title = title;  // title 필드에 받은 title 값 저장
        this.description = description;  // description 필드에 받은 description 값 저장
    }
}
