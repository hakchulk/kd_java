package com.study.spring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j // simple logging facade for java
public class BbsDAO implements IBbsDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<BbsDTO> listDAO() {
		log.info("=================== listDAO()");
//		log.error("log.erro test ");
		String q = "select * from simple_bbs order by id desc";
		List<BbsDTO> l = jdbcTemplate.query(q, new BeanPropertyRowMapper<>(BbsDTO.class));
		return l;
	}

	@Override
	public Integer countDAO() {
		log.info("=================== countDAO()");

		String q = "select count(*) from simple_bbs";
		Integer count = jdbcTemplate.queryForObject(q, Integer.class);
		return count;
	}

	@Override
	public BbsDTO viewDAO(String id) {
		log.info("=================== viewDAO()");
		String q = "select * from simple_bbs where id=" + id;
		BbsDTO dto = jdbcTemplate.queryForObject(q, new BeanPropertyRowMapper<>(BbsDTO.class));
		return dto;
	}

	@Override
	public int writeDAO(String writer, String title, String content) {
		log.info("=================== writeDAO()");
		String q = "insert into simple_bbs (writer, title, content) values (?,?,?)";
		int r = jdbcTemplate.update(q, writer, title, content);
		return r;
	}

	@Override
	public int deleteDAO(String id) {
		log.info("=================== deleteDAO()");
		System.out.println("deleteDAO");
		String q = "delete from simple_bbs where id=?";
		Integer count = jdbcTemplate.update(q, Integer.parseInt(id));
		return count;
	}

}
