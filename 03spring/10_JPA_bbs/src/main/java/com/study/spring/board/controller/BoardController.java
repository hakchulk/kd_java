package com.study.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.board.dto.BoardListImageDto;
import com.study.spring.board.dto.BoardListMemberDto;
import com.study.spring.board.entity.Board;
import com.study.spring.board.repository.BoardRepository;
import com.study.spring.board.service.BoardListService;

@RestController
public class BoardController {
	@GetMapping("/api")
	public String root() {
		return "BoardController.root()";
	}
	/*
	 * @Autowired BoardService boardService;
	 * 
	 * @GetMapping("/api") public String root() { return "BoardController.root()"; }
	 * 
	 * @GetMapping("/api/board") public List<Board> getBoardList() { return
	 * boardService.getBoardList(); }
	 * 
	 * @GetMapping("/api/boarddto") public List<BoardListDto> getBoardListDto() {
	 * return boardService.getBoardListDto(); }
	 * 
	 * @GetMapping("/api/board2/{id}") public Board findById(@PathVariable("id")
	 * Long id) { return boardService.getBoardWithException(id); }
	 * 
	 * @GetMapping("/api/board/{id}") public Optional<Board>
	 * getBoard(@PathVariable("id") Long id) { return boardService.getBoard(id); }
	 * 
	 * // pagination
	 * 
	 * @GetMapping("/api/boardpage") public Page<Board>
	 * getBoardPageList(@RequestParam(name = "page", defaultValue = "0") int page,
	 * 
	 * @RequestParam(name = "size", defaultValue = "10") int size) { return
	 * boardService.getBoardPageList(page, size); }
	 * 
	 * // 글작성
	 * 
	 * @PostMapping("api/board") public Board boardWrite(@RequestBody Board request)
	 * { return boardService.boardWrite(request); }
	 * 
	 */

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	BoardListService boardListService;

//	@GetMapping("/api/board")
	List<Board> findAll() {
		return boardRepository.findAll();
	}

	@GetMapping("/api/board")
	List<BoardListMemberDto> findWithMemberById() {
		return boardListService.findWithMemberById();

	}

	@GetMapping("/api/boardi")
	public List<BoardListImageDto> boardImageList() {
		return boardListService.findWithImage();
	}

	// /api/boardp?page=0&size=10
	@GetMapping("/api/boardp")
	public Page<BoardListImageDto> boardListImagePage(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
//		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
		Pageable pageable = PageRequest.of(page, size);

		return boardListService.findWithImagePage(pageable);
	}

	@GetMapping("/api/boardi/{id}")
	public BoardListImageDto boardListView(@PathVariable("id") Long id) {
		return boardListService.findWithImageById(id);
	}
}
