package com.study.spring.store;

import lombok.Data;

@Data
public class MenuDto {
	Long id;
	String name;
	Integer price;
	Long store_id;
}
