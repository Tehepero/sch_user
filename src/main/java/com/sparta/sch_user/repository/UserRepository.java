package com.sparta.sch_user.repository;  // 리포지토리 패키지. DB와 상호작용하는 객체들이 모인 곳

import com.sparta.sch_user.entity.User;  // User 엔티티 클래스 import. DB의 'User' 테이블과 매핑된 클래스
import org.springframework.data.jpa.repository.JpaRepository;  // Spring Data JPA에서 제공하는 인터페이스. CRUD 기능 자동 제공

// User 엔티티에 대한 리포지토리 인터페이스
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository를 상속받아서 기본적인 CRUD 작업을 User 엔티티에 대해 처리할 수 있음.
    // User 엔티티는 'User' 테이블을, Long은 기본 키 타입을 나타냄

    // 이메일로 사용자 조회하는 메서드 추가
    User findByEmail(String email);  // 이메일로 사용자를 조회하는 쿼리 메서드
}
