package com.study.spring.file;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TestDto {
	public String title;
	public String content;
	public String name;

	public List<MultipartFile> fileUpload;
}
