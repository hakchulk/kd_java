package com.study.spring.bbs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BbsController {
	@Autowired
	BbsRepository bbsRepository;

	@GetMapping("/")
	public String root() {
		return "hi! root";
	}

	@GetMapping("/api/bbsall")
	public List<Bbs> bbsListAll() {
		return bbsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
//		return bbsRepository.findAllByOrderByNameDesc();
	}

	// pagenation
	// 예)
	// https://jsonplaceholder.typicode.com/posts?_limit=5&_page=2&_sort=id&_order=desc
	// /api/bbs?size=10&page=0&title=생일
	@GetMapping("/api/bbs")
	public Page<Bbs> bbsListpagenation(@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "title", defaultValue = "") String title) {
		Pageable p = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));

		return bbsRepository.findByTitleContaining(title, p);
//		return bbsRepository.findAll(p);
	}

	@GetMapping("/api/bbs/{id}")
	public Optional<Bbs> findById(@PathVariable("id") Long id) {
		return bbsRepository.findById(id);
	}

	@PostMapping("/api/bbs")
	public Bbs bbsCreate(@RequestBody Bbs req) {
		return bbsRepository.save(req);
//		Bbs bbs = Bbs.builder().name(req.getName()).title(req.getTitle()).content(req.getContent()).build();
//		return bbsRepository.save(bbs);
	}

	@DeleteMapping("/api/bbs/{id}")
	public ResponseEntity<?> bbsDelete(@PathVariable("id") Long id) {
		boolean b = bbsRepository.existsById(id);
		if (!b) {
//			return ResponseEntity.notFound().build();
			return ResponseEntity.status(404).body("해당 ID의 게시글이 존재하지 않습니다. id:" + id);
		}
		bbsRepository.deleteById(id);
		return ResponseEntity.ok("삭제완료");
	}

	@PutMapping("/api/bbs/{id}")
	public void bbsUpdate(@PathVariable("id") Long id, @RequestBody Bbs req) {
		Optional<Bbs> view = bbsRepository.findById(id);
//		Bbs view = bbsRepository.findById(id).orElseThrow(() -> new RuntimeException("자료없음!"));

		log.info("--------bbsUpdate() view:" + view.toString());
		if (!view.isEmpty()) {
			Bbs e = view.get();
			e.setName(req.getName());
			e.setTitle(req.getTitle());
			e.setContent(req.getContent());
			bbsRepository.save(e);
		}
	}
}
