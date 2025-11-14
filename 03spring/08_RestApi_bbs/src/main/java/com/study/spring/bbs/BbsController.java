package com.study.spring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BbsController {
	@Autowired
	IBbsDao dao;

	@GetMapping("/")
	public String root() {
		return "Bbs root";
	}

//	Bbs
	@GetMapping("api/bbs")
	public List<BbsDto> listBbs() {
		return dao.findAll();
	}

	@PostMapping("api/bbs")
	public void createBbs(@RequestBody BbsDto req) {
		log.info("--------createBbs() name:", req.getName());
		dao.createBbs(req);
	}

	@GetMapping("/api/bbs/{id}")
	public BbsDto getBbs(@PathVariable("id") Long id) {
		return dao.getBbs(id);
	}

	@DeleteMapping("/api/bbs")
	public ResponseEntity<String> delete(@RequestParam("id") Long id) {
		log.info("--------delete() id:" + id);
		int deletedCnt = dao.deleteBbs(id);
		log.info("--------delete() deletedCnt:" + deletedCnt);
		if (deletedCnt > 0)
			return ResponseEntity.ok("delete succeed");
		else
			return ResponseEntity.badRequest().body("delete failed");
	}

	@PatchMapping("/api/bbs")
	public void updateBbs(@RequestBody BbsDto req) {
		dao.updateBbs(req);
	}

}
