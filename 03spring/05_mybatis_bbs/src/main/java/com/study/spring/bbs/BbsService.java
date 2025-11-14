package com.study.spring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsService {
	@Autowired
	IBbsDao dao;

	public List<BbsDto> getList() {
		return dao.listDao();
	}

	public int count() {
		return dao.countDao();
	}

	public BbsDto view(String id) {
		return dao.viewDao(id);
	}

	public int write(String writer, String title, String content) {
		return dao.writeDao(writer, title, content);
	}

	public int delete(String id) {
		return dao.deleteDao(id);

	}

}
