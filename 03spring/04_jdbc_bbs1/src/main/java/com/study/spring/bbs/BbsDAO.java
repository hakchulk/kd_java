package com.study.spring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	List<BbsDTO> getBbsDTO() {
		String q = "select * from simple_bbs order by id desc";
		List<BbsDTO> l = jdbcTemplate.query(q, new BeanPropertyRowMapper<>(BbsDTO.class));
		return l;
	}
}
