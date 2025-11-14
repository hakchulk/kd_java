package com.study.spring.bbstest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.bbs.Bbs;
import com.study.spring.bbs.BbsRepository;

@SpringBootTest
public class BbsTest {

	@Autowired
	BbsRepository bbsRepo;

	@Test
	public void bbsInsert() {
//		for (int i = 0; i < 3; i++) {
//			Bbs bbs = new Bbs();
//			bbs.setName("홍길동" + i);
//			bbs.setTitle("title");
//			bbs.setContent("content 안녕");
//
//			bbsRepo.save(bbs);
//		}
		Bbs bbs = Bbs.builder().name("나나3").title("나나생일").content("생일추카").build();
		bbsRepo.save(bbs);
	}
}
