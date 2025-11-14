package com.study.spring.api;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class PostDto {
	private int id;
	private String title;
	private String content;
	private String name;
	private Timestamp created_at;

	public String createdat() {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = created_at.toLocalDateTime();
		String formattedDate1 = ldt.format(formatter1);
		return formattedDate1;
	}
}
