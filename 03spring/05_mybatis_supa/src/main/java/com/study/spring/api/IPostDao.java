package com.study.spring.api;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IPostDao {
	@Select("select * from posts order by id desc")
	public List<PostDto> listDao();

	@Select("select count(*) from posts")
	public Integer countDao();

	@Select("select * from posts where id=#{id}")
	public PostDto viewDao(Integer id); // view 글내용
//
//	@Insert("insert into posts (name,title,content) values (#{param1},#{param2},#{param3})")
//	public int writeDao(String nme, String title, String content);
//
//	@Delete("delete from posts where id=#{id}")
//	public int deleteDao(String id);
}
