package com.study.spring.board.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.spring.board.dto.BoardListImageDto;
import com.study.spring.board.dto.BoardListMemberDto;
import com.study.spring.board.dto.ImageDto;
import com.study.spring.board.entity.Board;
import com.study.spring.board.entity.Image;
import com.study.spring.board.repository.BoardRepository;

@Service
public class BoardListService {

	@Autowired
	BoardRepository boardRepository;

	public List<BoardListMemberDto> findWithMemberById() {

		return boardRepository.findWithMemberById();
	}

//	public List<BoardListImageDto> findWithImage() {
//	List<Board> boards = boardRepository.findWithImage();
//	return boards.stream().map(b -> {
//		BoardListImageDto dto = BoardListImageDto.builder().title(b.getTitle()).memberName(b.getMember().getName())
//				.memberEmail(b.getMember().getEmail()).content(b.getContent()).createdAt(b.getCreatedAt())
//				.images(b.getImages().stream()
//						.map(img -> new ImageDto(img.getId(), img.getImageOrder(), img.getFileName())).toList())
//				.build();
//		return dto;
//	}).toList();
//}	

	private BoardListImageDto board2BoardListImageDto(Board b) {
		BoardListImageDto dto = BoardListImageDto.builder().id(b.getId()).title(b.getTitle())
				.memberName(b.getMember().getName()).memberEmail(b.getMember().getEmail()).content(b.getContent())
				.createdAt(b.getCreatedAt()).imageCount(b.getImages().size()).build();

		List<ImageDto> lidto = b.getImages().stream().sorted(Comparator.comparing(Image::getImageOrder).reversed())
//				.sorted(Comparator.comparing(img -> img.getImageOrder()))
				.map(img -> new ImageDto(img.getId(), img.getImageOrder(), img.getFileName())).toList();

		dto.setImages(lidto);
		return dto;
	}

	public List<BoardListImageDto> findWithImage() {
		List<Board> boards = boardRepository.findWithImage();
		List<BoardListImageDto> dtol = boards.stream().map(b -> board2BoardListImageDto(b)).toList();
		return dtol;
	}

	// Page<>.map()
	public Page<BoardListImageDto> findWithImagePage(Pageable pageable) {
		Page<Board> page = boardRepository.findWithImagePage(pageable);

		Page<BoardListImageDto> retPage = page.map(b -> board2BoardListImageDto(b));
		return retPage;
	}

	public BoardListImageDto findWithImageById(Long id) {
		return board2BoardListImageDto(boardRepository.findWithImageById(id));
	}

}
