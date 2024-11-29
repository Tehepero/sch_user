package com.sparta.sch_user.dto;  // DTO 패키지. 클라이언트와 서버 간에 데이터를 주고받을 때 사용하는 객체들 모음

import com.sparta.sch_user.entity.User;  // User 엔티티 클래스 import. 이 DTO에서 받은 데이터를 User 엔티티로 변환할 거야

import lombok.Getter;  // Lombok의 @Getter 어노테이션을 사용해서 필드에 대한 getter 메서드를 자동으로 생성해줌

@Getter  // 이 어노테이션 덕분에 writerName, email, password에 대해 자동으로 getter 메서드가 생성됨
public class UserRequestDto {  // 새로운 사용자 정보를 받을 DTO 클래스야

    private final String writerName;  // 사용자의 이름을 담는 필드, writerName은 그냥 예시로 들은 이름일 뿐이지
    private final String email;  // 사용자의 이메일 주소
    private final String password;  // 사용자의 비밀번호

    // 생성자. 사용자가 입력한 name, email, password를 받아서 이 DTO 객체를 초기화하는 역할
    public UserRequestDto(String writerName, String email, String password) {
        this.writerName = writerName;  // writerName 필드에 받은 이름 값 저장
        this.email = email;  // email 필드에 받은 이메일 값 저장
        this.password = password;  // password 필드에 받은 비밀번호 값 저장
    }

    // 이 메서드는 UserRequestDto에서 받은 데이터를 User 엔티티 객체로 변환해주는 역할
    public User toEntity() {
        return new User(
                this.writerName,  // User 엔티티의 writerName 필드에 DTO에서 받은 writerName 값 넣어줌
                this.email,  // User 엔티티의 email 필드에 DTO에서 받은 email 값 넣어줌
                this.password  // User 엔티티의 password 필드에 DTO에서 받은 password 값 넣어줌
        );
    }
}
