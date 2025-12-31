package com.study.spring.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.spring.board.dto.BoardListDto;
import com.study.spring.board.entity.Board;
import com.study.spring.board.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	BoardRepository boardRepository;

	public List<Board> getBoardList() {
		return boardRepository.findAllOrderByIdDesc();
	}

	public List<BoardListDto> getBoardListDto() {
		return boardRepository.findAllListDto();
	}

	public Board getBoardWithException(Long id) {
		return boardRepository.findBoard(id).orElseThrow(() -> new RuntimeException("게시글이 없습니다. id=" + id));
	}

	public Optional<Board> getBoard(Long id) {
		// id가 없을 때 null 반환
		return boardRepository.findBoard(id);
	}

	public Page<Board> getBoardPageList(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);

		return boardRepository.findAllWithPage(pageable);

	}

	public Board boardWrite(Board request) {
		Board board = new Board();
		board.setName(request.getName());
		board.setTitle(request.getTitle());
		board.setContent(request.getContent());

		return boardRepository.save(board);
	}

}
