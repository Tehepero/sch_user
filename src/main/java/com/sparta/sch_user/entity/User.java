package com.sparta.sch_user.entity;  // 엔티티 패키지. 데이터베이스와 연결되는 객체들 모음

import jakarta.persistence.*;  // JPA 관련 어노테이션들을 가져오는 import
import lombok.Getter;  // Lombok의 @Getter 어노테이션을 사용해서 필드에 대한 getter 메서드를 자동으로 생성해줌

@Entity  // 이 클래스는 JPA 엔티티라는 걸 알려주는 어노테이션. 즉, DB 테이블에 매핑된 객체라는 뜻
@Getter  // 이 어노테이션 덕분에 id, writerName, email, password에 대한 getter 메서드가 자동으로 생성됨
public class User extends BaseEntity {  // User 클래스는 BaseEntity를 상속받아서 생성일자, 수정일자 자동 관리됨

    @Id  // 이 필드는 엔티티의 기본 키(primary key)라는 걸 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 기본 키 값을 자동으로 생성하도록 설정. DB에서 증가값을 자동으로 관리함
    private Long id;  // 사용자의 고유 ID

    private String writerName;  // 사용자의 이름

    private String email;  // 사용자의 이메일

    private String password;  // 사용자의 비밀번호

    // 기본 생성자 (JPA에서 필요할 때 사용)
    public User() {}

    // 사용자 이름, 이메일, 비밀번호를 받아서 새로운 User 객체를 생성하는 생성자
    public User(String writerName, String email, String password) {
        this.writerName = writerName;  // writerName 필드에 사용자의 이름을 저장
        this.email = email;  // email 필드에 사용자의 이메일을 저장
        this.password = password;  // password 필드에 사용자의 비밀번호를 저장
    }
}
