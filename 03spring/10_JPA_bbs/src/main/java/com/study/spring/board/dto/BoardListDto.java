package com.study.spring.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardListDto {
	private Long id;
	private String title;
	private String name;
	private LocalDateTime createAt;
}
