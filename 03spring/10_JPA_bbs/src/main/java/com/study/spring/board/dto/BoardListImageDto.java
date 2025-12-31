package com.study.spring.board.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BoardListImageDto {
	private Long id;

	private String title;
	private String memberName;
	private String memberEmail;
	private String content;
	private int imageCount;
	private LocalDateTime createdAt;

	@Builder.Default // If you want the initializing expression to serve as default
	private List<ImageDto> images = new ArrayList<>();
}
