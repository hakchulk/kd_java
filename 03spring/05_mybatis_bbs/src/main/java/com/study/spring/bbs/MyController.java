package com.study.spring.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

//	@Autowired
//	IBbsDao dao;

	@Autowired
	BbsService svc;

	@RequestMapping("/")
//	@ResponseBody
	public String root() {
		return "redirect:list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("lists", svc.getList());
		model.addAttribute("count", svc.count());
		return "list"; // model로 들어온 데이터를 전송
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		model.addAttribute("item", svc.view(id));
		return "view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest req) {
		svc.write(req.getParameter("writer"), req.getParameter("title"), req.getParameter("content"));

		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		svc.delete(id);
		return "redirect:list";
	}

	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}

//	@RequestMapping("/list")
//	public String list(Model model) {
//		model.addAttribute("lists", dao.listDao());
//		model.addAttribute("count", dao.countDao());
//		return "list"; // model로 들어온 데이터를 전송
//	}
//
//	@RequestMapping("/view")
//	public String view(HttpServletRequest req, Model model) {
//		String id = req.getParameter("id");
//		model.addAttribute("item", dao.viewDao(id));
//		return "view";
//	}
//
//	@RequestMapping("/write")
//	public String write(HttpServletRequest req) {
//		dao.writeDao(req.getParameter("writer"), req.getParameter("title"), req.getParameter("content"));
//
//		return "redirect:list";
//	}
//
//	@RequestMapping("/delete")
//	public String delete(HttpServletRequest req) {
//		String id = req.getParameter("id");
//		dao.deleteDao(id);
//		return "redirect:list";
//	}
//
//	@RequestMapping("/writeForm")
//	public String writeForm() {
//		return "writeForm";
//	}	
}
