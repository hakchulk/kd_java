package com.study.spring.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IBbsDao {
	@Select("select * from simple_bbs order by id desc")
	public List<BbsDto> listDao();

	@Select("select count(*) from simple_bbs")
	public Integer countDao();

	@Select("select * from simple_bbs where id=#{id}")
	public BbsDto viewDao(String id); // view 글내용

	@Insert("insert into simple_bbs (writer,title,content) values (#{param1},#{param2},#{param3})")
	public int writeDao(String writer, String title, String content);

	@Delete("delete from simple_bbs where id=#{id}")
	public int deleteDao(String id);
}
