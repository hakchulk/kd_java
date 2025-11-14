package com.study.spring.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	@RequestMapping("/")
	@ResponseBody
	public String root() {
		return "jsp 입니다";
	}																																																																																																																																																																																																																																																	
	
	// http://localhost:8080/view1?name=이순신&age=30	
//	@RequestMapping(value = "/view1", method = RequestMethod.GET)
	@RequestMapping("/view1")
	public String view1(@RequestParam("name") String name, @RequestParam("age") String age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		System.out.println(name);
		return "view1";
	}
	
	// http://localhost:8080/index?name=이순신&age=30

//	@GetMapping("/index")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest req, Model model) {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		System.out.println(name);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "index";
	}
	
	@RequestMapping("/view2")
	public String view2(Member member, // DTO : data transfer object, DAO (Data Access Object)
			Model model
			) {
		return "view2";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("/test1/{myID}/{myNum}")
	public String test1(
			@PathVariable("myID") String myID,
			@PathVariable("myNum") String myNum,
			Model model
			) {
		
		System.out.println(myID);
		
		model.addAttribute("id", myID);
		model.addAttribute("num", myNum);
		return "test1"; 
	}
	
	@GetMapping("/test2")
	public String Test2(Model model) {
			model.addAttribute("name", "hak");
		return "test2";
	}
	
	@GetMapping("/test3")
	public String Test3(Model model) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		model.addAttribute("list", list);
		return "test3";
	}
}
