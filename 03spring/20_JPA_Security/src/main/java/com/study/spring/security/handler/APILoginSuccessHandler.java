package com.study.spring.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.google.gson.Gson;
import com.study.spring.member.dto.MemberDto;
import com.study.spring.util.JWTUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class APILoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info(
				"-------------------------- APILoginSuccessHandler.onAuthenticationSuccess() ------------------------------------");
		log.info(authentication.getPrincipal());
		log.info("--------------------------------------------------------------");

		MemberDto memberDto = (MemberDto) authentication.getPrincipal();
		log.info(memberDto);

		Map<String, Object> claims = memberDto.getClaims();

		String accessToken = JWTUtil.generateToken(claims, 10); // 10분
		String refreshToken = JWTUtil.generateToken(claims, 60 * 24); // 24시간

		jakarta.servlet.http.Cookie refreshTokenCookie = new jakarta.servlet.http.Cookie("refreshToken", refreshToken);
		refreshTokenCookie.setHttpOnly(true);
		refreshTokenCookie.setPath("/");
		refreshTokenCookie.setMaxAge(60 * 60 * 24); // 24시간
		refreshTokenCookie.setAttribute("SameSite", "Lax"); // Lax : 외부 사이트에서 링크 클릭 (GET) 허용. 예) 이메일로 "비밀번호 변경" 링크
		response.addCookie(refreshTokenCookie);

		claims.put("accessToken", accessToken);

		Gson gson = new Gson();
		String jsonStr = gson.toJson(claims);

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println(jsonStr);
		printWriter.close();
	}

}
