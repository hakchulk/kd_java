package com.study.spring.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/")
	public String root() {
		return "hello RESTfull API";
	}

	@GetMapping("/hello/world")
	public String helloWorld() {
		return "hello Spring";
	}

	@PostMapping("/hello/world")
	public String postHelloWorld() {
		return "post hello Spring";
	}

	@PutMapping("/hello/world")
	public String putHelloWorld() {
		return "put hello Spring";
	}

	@DeleteMapping("/hello/world")
	public String deleteHelloWorld() {
		return "delete hello Spring";
	}

	@GetMapping("/test/param")
	public String requesParams(@RequestParam("name") String name, @RequestParam("age") Integer age) {
		return "hello, request pram, I am " + name + ", age:" + age;

	}

	@GetMapping("/test/path/{name}/{age}")
	public String reqPathParams(@PathVariable("name") String name, @PathVariable Integer age) {
		return "hello, path pram, I am " + name + ", age:" + age;
	}

	@PostMapping("/test/body")
	public String reqBody(@RequestBody TestDto req) {
		return "reqBody() name:" + req.name + ", age:" + req.age + ", addr:" + req.addr + ", hobby:" + req.hobby;
	}
}
