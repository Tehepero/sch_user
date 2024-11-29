package com.sparta.sch_user.dto;  // DTO(Data Transfer Object) 패키지야. 데이터를 주고받을 때 사용되는 클래스들 모음.

import lombok.Getter;  // Lombok의 @Getter 어노테이션을 사용해서, 필드에 대한 getter 메서드를 자동으로 만들어주는 거야.

@Getter  // 클래스에 이 어노테이션 달면, email과 password에 대한 getter 메서드가 자동으로 만들어짐.
public class LoginRequestDto {  // 로그인 요청을 받을 때 사용할 DTO 클래스임. 클라이언트에서 보낸 로그인 정보 담을 거야.

    private final String email;  // 사용자의 이메일, 로그인할 때 필요함.
    private final String password;  // 사용자의 비밀번호, 로그인할 때 필요함.

    // 생성자. email과 password를 받아서 초기화함.
    public LoginRequestDto(String email, String password) {
        this.email = email;  // email 필드에 받은 값을 저장
        this.password = password;  // password 필드에 받은 값을 저장
    }
}
