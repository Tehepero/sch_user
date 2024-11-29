package com.sparta.sch_user.dto;  // DTO 패키지. 데이터를 클라이언트와 서버 간 주고받을 때 사용하는 객체들 모음

import com.sparta.sch_user.entity.User;  // User 엔티티를 import. 이 엔티티의 데이터를 가져와서 응답할 DTO로 변환할 거야

import lombok.Getter;  // Lombok의 @Getter 어노테이션을 사용해서 필드에 대한 getter 메서드를 자동으로 생성해줌

import java.time.LocalDateTime;  // 날짜와 시간을 다루는 LocalDateTime 클래스를 import. 생성일자, 수정일자 같은 정보에 사용됨

@Getter  // 이 어노테이션 덕분에 id, writerName, email, createdAt, modifiedAt에 대한 getter 메서드가 자동으로 생성됨
public class UserResponseDto {  // 사용자 정보 조회할 때, 응답 데이터를 담는 DTO 클래스

    private final Long id;  // 사용자 고유 ID
    private final String writerName;  // 사용자의 이름
    private final String email;  // 사용자의 이메일
    private final LocalDateTime createdAt;  // 사용자가 생성된 시간
    private final LocalDateTime modifiedAt;  // 사용자가 마지막으로 수정된 시간

    // 생성자. 이 클래스의 객체를 만들 때, 받은 값으로 초기화하는 역할
    public UserResponseDto(Long id, String writerName, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;  // id 필드에 사용자 ID 값 저장
        this.writerName = writerName;  // writerName 필드에 사용자 이름 값 저장
        this.email = email;  // email 필드에 사용자 이메일 값 저장
        this.createdAt = createdAt;  // createdAt 필드에 생성 시간 값 저장
        this.modifiedAt = modifiedAt;  // modifiedAt 필드에 수정 시간 값 저장
    }

    // User 엔티티 객체를 받아서 UserResponseDto로 변환하는 메서드
    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),  // User 엔티티에서 id 값 가져오기
                user.getWriterName(),  // User 엔티티에서 writerName 값 가져오기
                user.getEmail(),  // User 엔티티에서 email 값 가져오기
                user.getCreatedAt(),  // User 엔티티에서 createdAt 값 가져오기
                user.getModifiedAt()  // User 엔티티에서 modifiedAt 값 가져오기
        );
    }
}
