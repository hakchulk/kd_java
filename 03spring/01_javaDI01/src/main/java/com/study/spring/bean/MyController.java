package com.study.spring.bean;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Controller
public class MyController {
	@Autowired
	Member member1;
	
	@Autowired
	@Qualifier("printerB")
	Printer printerB;
	
	@Autowired
    private ApplicationContext context;
	
	@RequestMapping("/")
	@ResponseBody
	public String root() {
		member1.print();
		
		member1.setPrinter(printerB);
		member1.print();
		
//		String[] beanNames = context.getBeanDefinitionNames();
//        Arrays.sort(beanNames); // 보기 좋게 정렬
//        for (String name : beanNames) {
//            System.out.println(name);
//        }
		
		return "안녕하세요!";
	}
}
