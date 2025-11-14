package com.study.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	IPostDao dao;

	@GetMapping("/")
	public String root() {
		return "hello RESTfull API";
	}

	@GetMapping("/api/posts")
	public List<PostDto> postView() {
		return dao.listDao();
	}

	@GetMapping("/api/count")
	public Integer postCount() {
		return dao.countDao();
	}

	@GetMapping("/api/viewpost")
	public PostDto view(@RequestParam("id") String id) {
		return dao.viewDao(Integer.parseInt(id));
	}

	@GetMapping("api/test")
	public String requesParams(@RequestParam("name") String name, @RequestParam("age") String age) {

		return "hello, request pram, i am " + name + ", age:" + age;

	}

	@GetMapping("api/view/{name}/{age}")
	public String pathParams(@PathVariable("name") String name, @PathVariable("age") String age) {

		return "hello, request pram, i am " + name + ", age:" + age;

	}

	@GetMapping("api/dtest")
	public String dtoTest(@ModelAttribute TestDto dto) {
		return "hello, request pram, i am " + dto.name + ", age:" + dto.age;

	}

}
