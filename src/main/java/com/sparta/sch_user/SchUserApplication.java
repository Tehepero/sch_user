package com.sparta.sch_user;  // 프로젝트의 메인 패키지. 앱이 시작되는 곳

import org.springframework.boot.SpringApplication;  // Spring Boot 애플리케이션 실행을 위한 클래스
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Spring Boot 애플리케이션 설정 어노테이션
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;  // JPA 감사 기능 활성화 어노테이션

@EnableJpaAuditing  // JPA 감사 기능 활성화. 엔티티의 생성/수정 시간 같은 정보를 자동으로 처리해줌
@SpringBootApplication  // Spring Boot 애플리케이션의 메인 설정 어노테이션. 이 어노테이션이 있으면 스프링 부트 앱이 설정되고 실행됨
public class SchUserApplication {  // 메인 애플리케이션 클래스

    public static void main(String[] args) {  // 애플리케이션 실행을 위한 main 메서드
        SpringApplication.run(SchUserApplication.class, args);  // 스프링 부트 애플리케이션 실행
    }

}
