package com.study.spring.bbs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/list")
	public String list() {
		return "list";
	}
}
