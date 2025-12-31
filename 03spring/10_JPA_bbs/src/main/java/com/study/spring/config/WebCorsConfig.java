package com.study.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCorsConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**") // 💡 모든 엔드포인트 (e.g., /api/...) 에 적용
				.allowedOriginPatterns("*")
//				.allowedOrigins("http://localhost:5173") // 💡 허용할 출처(Origin) 명시
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
				.allowedHeaders("Content-Type", "Authorization").exposedHeaders("Location").allowCredentials(true)
				.maxAge(3600);
	}
}
