package com.study.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // spring 설정 클래스
public class Config {
	
	@Bean
	Member member1() {
		Member member1 = new Member();
		member1.setName("hakchul");
		member1.setNickname("hak");
		member1.setPrinter(new PrinterA());
		return member1;
	}

	@Bean(name="hello")
	Member member2() {
		return new Member("홍", "길동", new PrinterA());
	}
	
	@Bean
	PrinterA printerA() {
		return new PrinterA();
	}
	
	@Bean
	PrinterB printerB() {
		return new PrinterB();
	}
}
