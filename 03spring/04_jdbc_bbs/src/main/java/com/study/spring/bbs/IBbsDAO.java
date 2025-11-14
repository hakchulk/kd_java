package com.study.spring.bbs;

import java.util.List;

public interface IBbsDAO {
	public List<BbsDTO> listDAO();

	public Integer countDAO();

	public BbsDTO viewDAO(String id); // view 글내용

	public int writeDAO(String writer, String title, String content);

	public int deleteDAO(String id);
}
