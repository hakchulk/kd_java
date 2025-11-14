package com.study.spring.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {
	@Autowired
	IBbsDAO dao;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("lists", dao.listDAO());
		model.addAttribute("count", dao.countDAO());
		return "list";
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		model.addAttribute("item", dao.viewDAO(id));
		return "view";
	}

	// 글장성 form
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}

	// 글장성 action write?writer & title & content
	@RequestMapping("/write")
	public String write(HttpServletRequest req) {
		dao.writeDAO(req.getParameter("writer"), req.getParameter("title"), req.getParameter("content"));

		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		dao.deleteDAO(id);
		log.info("=============delete :" + id);
		return "redirect:list";
	}
}
