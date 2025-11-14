package com.study.spring.bbs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class BbsDto {
	private int id;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime created_at;

	public String createdat() {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate1 = created_at.format(formatter1);
		return formattedDate1;
	}

}
