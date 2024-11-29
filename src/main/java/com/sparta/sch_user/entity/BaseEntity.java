package com.sparta.sch_user.entity;  // 엔티티 패키지. 데이터베이스와 연결되는 객체들 모음

import jakarta.persistence.EntityListeners;  // 엔티티에 리스너를 설정할 때 사용하는 어노테이션
import jakarta.persistence.MappedSuperclass;  // 이 클래스가 상속될 수 있는 슈퍼클래스라는 걸 알려주는 어노테이션
import lombok.Getter;  // Lombok의 @Getter 어노테이션, 이 클래스의 모든 필드에 대해 getter 메서드를 자동으로 생성해줌
import org.springframework.data.annotation.CreatedDate;  // 엔티티 생성 시 날짜 자동으로 기록할 때 사용하는 어노테이션
import org.springframework.data.annotation.LastModifiedDate;  // 엔티티 수정 시 날짜 자동으로 기록할 때 사용하는 어노테이션
import org.springframework.data.jpa.domain.support.AuditingEntityListener;  // 데이터 변경 시 자동으로 날짜를 기록해주는 Auditing 리스너

import java.time.LocalDateTime;  // 날짜와 시간을 다루는 LocalDateTime 클래스, 생성일자와 수정일자에 사용

@Getter  // 이 어노테이션 덕분에 모든 필드에 대한 getter 메서드가 자동으로 생성됨
@MappedSuperclass  // 이 클래스는 테이블로 매핑되지 않고, 다른 엔티티 클래스들이 이 클래스를 상속받을 수 있다는 뜻
@EntityListeners(AuditingEntityListener.class)  // AuditingEntityListener를 사용해서 엔티티의 생성일자와 수정일자가 자동으로 관리되도록 설정
public abstract class BaseEntity {  // 모든 엔티티가 공통적으로 가질 생성일자, 수정일자 필드를 관리하는 추상 클래스

    @CreatedDate  // 엔티티가 처음 생성될 때 날짜가 자동으로 기록됨
    private LocalDateTime createdAt;  // 생성일자를 저장하는 필드

    @LastModifiedDate  // 엔티티가 수정될 때 날짜가 자동으로 기록됨
    private LocalDateTime modifiedAt;  // 수정일자를 저장하는 필드
}
