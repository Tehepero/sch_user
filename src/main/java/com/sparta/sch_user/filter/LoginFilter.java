package com.sparta.sch_user.filter;  // 필터 패키지. HTTP 요청을 가로채서 특정 작업을 수행할 때 사용되는 필터들 모음

import jakarta.servlet.*;  // 서블릿 관련 클래스들. 서블릿 요청/응답 처리
import jakarta.servlet.http.HttpServletRequest;  // HTTP 요청을 다룰 때 사용하는 클래스
import jakarta.servlet.http.HttpSession;  // HTTP 세션을 다룰 때 사용하는 클래스
import lombok.extern.slf4j.Slf4j;  // 로깅을 위한 Lombok 어노테이션, 로그 찍는 코드 간편하게 만들어줌
import org.springframework.util.PatternMatchUtils;  // URI 패턴을 매칭하는 유틸리티 클래스

import java.io.IOException;  // 예외 처리에 필요한 IO 예외 클래스

@Slf4j  // Lombok 어노테이션으로 log 객체를 자동으로 생성해줌. 로그 기록할 때 편함
public class LoginFilter implements Filter {  // Filter 인터페이스를 구현한 로그인 필터 클래스

    private static final String[] WHITE_LIST = {"/users", "/users/login"};  // 화이트리스트에 포함된 URI. 로그인 없이 접근 가능

    @Override
    public void doFilter(
            ServletRequest request,  // 서블릿 요청 객체
            ServletResponse response,  // 서블릿 응답 객체
            FilterChain chain  // 필터 체인. 요청을 다음 필터나 서블릿으로 전달
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;  // ServletRequest를 HttpServletRequest로 변환
        String requestURI = httpRequest.getRequestURI();  // 요청 URI 추출

        log.info("로그인 필터 로직 실행");  // 필터가 실행될 때 로그 남김

        if (!isWhiteList(requestURI)) {  // 화이트리스트에 포함된 URI가 아니면 로그인 체크

            HttpSession session = httpRequest.getSession(false);  // 기존 세션을 가져오는데, 없으면 null 반환
            if (session == null || session.getAttribute("SESSION_KEY") == null) {  // 세션이 없거나 로그인 키가 없으면
                throw new RuntimeException("로그인 해주세요.");  // 예외 던져서 로그인 안 한 사용자 차단
            }

            log.info("로그인된 사용자 요청: {}", requestURI);  // 로그인된 사용자가 요청한 URI 로그 남기기
        }

        chain.doFilter(request, response);  // 필터 체인으로 요청을 계속 전달
    }

    // 화이트리스트에 포함된 URI인지 확인하는 메서드
    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);  // URI가 화이트리스트 패턴에 맞는지 체크
    }
}
