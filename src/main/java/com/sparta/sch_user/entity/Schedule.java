package com.sparta.sch_user.entity;  // 엔티티 패키지. 데이터베이스와 연결되는 객체들 모음

import jakarta.persistence.*;  // JPA 관련 어노테이션들을 가져오는 import
import lombok.Getter;  // Lombok의 @Getter 어노테이션을 사용해서 필드에 대한 getter 메서드를 자동으로 생성해줌

@Entity  // 이 클래스는 JPA 엔티티라는 걸 알려주는 어노테이션. 즉, DB 테이블에 매핑된 객체라는 뜻
@Getter  // 이 어노테이션 덕분에 id, title, description, user 등에 대해 getter 메서드가 자동으로 생성됨
public class Schedule extends BaseEntity {  // Schedule 클래스는 BaseEntity를 상속받아서 생성일자, 수정일자 자동 관리됨

    @Id  // 이 필드는 엔티티의 기본 키(primary key)라는 걸 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 이 필드는 데이터베이스에서 자동으로 증가하는 값으로 설정, 기본 키 자동 생성
    private Long id;  // 일정의 고유 ID

    private String title;  // 일정 제목

    private String description;  // 일정 설명

    @ManyToOne  // 이 클래스는 다대일 관계(Many-to-One)로, 여러 스케줄이 하나의 사용자와 연결된다는 뜻
    @JoinColumn(name = "user_id")  // user_id라는 컬럼을 통해 user 테이블과 조인되는 관계를 설정
    private User user;  // 일정과 연결된 사용자 객체

    // 생성자. 사용자가 만든 일정에 대한 정보 (사용자, 제목, 설명)를 받아서 스케줄 객체를 초기화함
    public Schedule(User user, String title, String description) {
        this.user = user;  // user 필드에 사용자가 입력한 user 객체 저장
        this.title = title;  // title 필드에 사용자가 입력한 제목 저장
        this.description = description;  // description 필드에 사용자가 입력한 설명 저장
    }

    // 기본 생성자 (JPA에서 필요할 때 사용)
    public Schedule() {}

    // 업데이트 메서드. 제목과 설명을 수정할 때 사용
    public void update(String title, String description) {
        this.title = title;  // title 필드를 새 제목으로 업데이트
        this.description = description;  // description 필드를 새 설명으로 업데이트
    }
}
