package com.sparta.sch_user.config;  // 패키지 선언. sch_user.config 패키지 내의 클래스임을 나타냄.

import com.sparta.sch_user.filter.LoginFilter;  // LoginFilter 클래스를 임포트. 필터로 사용할 클래스.
import jakarta.servlet.Filter;  // javax.servlet 패키지에서 제공하는 Filter 인터페이스를 임포트.
import org.springframework.boot.web.servlet.FilterRegistrationBean;  // Spring Boot에서 제공하는 FilterRegistrationBean을 임포트.
import org.springframework.context.annotation.Bean;  // Spring의 Bean을 등록하는 어노테이션인 @Bean을 임포트.
import org.springframework.context.annotation.Configuration;  // 설정 클래스를 나타내는 @Configuration 어노테이션을 임포트.

@Configuration  // 이 클래스가 Spring의 설정 클래스임을 나타내는 어노테이션. 이 클래스는 Spring Context에 의해 관리됨.
public class WebConfig {  // 웹 관련 설정을 위한 클래스 WebConfig 선언.

    @Bean  // Spring에게 이 메서드가 반환하는 객체를 Bean으로 등록하라고 지시하는 어노테이션.
    public FilterRegistrationBean loginFilter() {  // loginFilter라는 이름의 메서드 정의. FilterRegistrationBean을 반환.
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();  // FilterRegistrationBean 객체를 생성. 필터를 등록할 용도.

        filterRegistrationBean.setFilter(new LoginFilter());  // LoginFilter를 필터로 등록. LoginFilter는 실제로 요청을 처리하는 필터 역할.

        filterRegistrationBean.setOrder(1);  // 필터의 우선순위를 설정. 1이면 가장 높은 우선순위로 동작.

        filterRegistrationBean.addUrlPatterns("/*");  // 필터를 적용할 URL 패턴을 설정. 여기서는 모든 요청(`/*`)에 대해 필터가 동작하도록 설정.

        return filterRegistrationBean;  // 설정한 FilterRegistrationBean을 반환. Spring이 이 Bean을 관리함.
    }
}
