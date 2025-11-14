package com.study.spring.store;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MenuStoreDto extends MenuDto {
	StoreDto store;
}
