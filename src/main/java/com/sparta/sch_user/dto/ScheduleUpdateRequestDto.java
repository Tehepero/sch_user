package com.sparta.sch_user.dto;  // DTO 패키지. 데이터를 클라이언트와 서버 간 주고받을 때 사용하는 객체들 모음

import lombok.Getter;  // Lombok의 @Getter 어노테이션을 사용해서 필드에 대한 getter 메서드를 자동으로 생성해줌

@Getter  // 이 어노테이션 덕분에 title과 description에 대한 getter 메서드가 자동으로 생성됨
public class ScheduleUpdateRequestDto {  // 스케줄을 업데이트할 때 클라이언트가 보낼 데이터를 담는 DTO 클래스

    private final String title;  // 새로운 제목, 업데이트할 제목을 담는 필드
    private final String description;  // 새로운 설명, 업데이트할 설명을 담는 필드

    // 생성자, 새로운 제목과 설명을 받아서 초기화하는 역할
    public ScheduleUpdateRequestDto(String title, String description) {
        this.title = title;  // title 필드에 받은 제목 값을 저장
        this.description = description;  // description 필드에 받은 설명 값을 저장
    }
}
