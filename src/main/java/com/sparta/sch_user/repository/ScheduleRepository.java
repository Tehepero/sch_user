package com.sparta.sch_user.repository;  // 리포지토리 패키지. DB와의 상호작용을 담당하는 클래스들이 들어있는 패키지

import com.sparta.sch_user.entity.Schedule;  // Schedule 엔티티 클래스 import. DB에서 사용될 테이블과 매핑된 클래스
import org.springframework.data.jpa.repository.JpaRepository;  // Spring Data JPA에서 제공하는 인터페이스. 기본적인 CRUD 기능 제공

// Schedule 엔티티를 다루는 리포지토리 인터페이스
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // JpaRepository를 상속받으면 Schedule 엔티티에 대해 기본적인 CRUD 작업을 다 할 수 있게 돼
    // Schedule 엔티티에 대해 DB에서 insert, update, delete, select 하는 것들이 자동으로 제공됨.
    // JpaRepository<Schedule, Long>에서 Schedule은 엔티티 클래스고, Long은 그 엔티티의 기본 키 타입
}
