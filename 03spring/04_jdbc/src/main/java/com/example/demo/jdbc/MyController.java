package com.example.demo.jdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MyController {
	
	@Autowired
	MyDao myDao;
	
	@RequestMapping("/")
	@ResponseBody
	public String root() {
		System.out.println("test");
		return "jdb 입니다";
	}
	
	@GetMapping("/list")
	public String index(Model model) {
		model.addAttribute("lists", myDao.list());
		return "index";
	}
}
