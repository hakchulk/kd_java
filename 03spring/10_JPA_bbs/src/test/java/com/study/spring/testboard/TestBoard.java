package com.study.spring.testboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.board.entity.Board;
import com.study.spring.board.repository.BoardRepository;
import com.study.spring.board.repository.ImageRepository;
import com.study.spring.member.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TestBoard {
	@Autowired
	MemberRepository memberRepository;

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	ImageRepository imageRepository;

//	@Test
//	public void insertBoard() {
//		Member member = memberRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("멤버없음!"));
//
////		Board board = new Board();
////		board.setTitle("title1");
////		board.setContent("content1");
////		board.setName("홍길동1");
////		board.setMember(member);
//		Board board = Board.builder().title("title2").content("content2").name("이순신").member(member).build();
//
//		Board saveBoard = boardRepository.save(board);
//		log.info("insertBoard() : saveBoard" + saveBoard);
//	}

//	@Test
//	public void insertImage() {
//		Board board = boardRepository.findById(15L).orElseThrow(() -> new IllegalArgumentException("board 없음!"));
//
//		Image image = Image.builder().fileName("filename1").originalFileName("originalFileName1").imageOrder(1)
//				.board(board).build();
//		Image saveImage = imageRepository.save(image);
//		log.info("insertImage() : 1 saveImage" + saveImage);
//		log.info("insertImage() : 저장된 이미지 id={}", saveImage.getId());
//		log.info("insertImage() : 저장된 파일명 ={}", saveImage.getOriginalFileName());
//	}

	@Test
	@Transactional
	public void getImageList() {
		Board board = boardRepository.findById(15L).orElseThrow(() -> new IllegalArgumentException("board 없음!"));

		System.out.println("==게시물===========================");
		System.out.println("id=" + board.getId());
		System.out.println("title=" + board.getTitle());
		System.out.println("==이미지===========================");

		board.getImages().forEach(img -> {
			System.out.println("img.getId() " + img.getId());
			System.out.println("img.getImageOrder() " + img.getImageOrder());
			System.out.println("img.getOriginalFileName() " + img.getOriginalFileName());
		});
	}

}
