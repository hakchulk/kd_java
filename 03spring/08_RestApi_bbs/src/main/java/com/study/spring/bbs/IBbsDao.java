package com.study.spring.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IBbsDao {
// Bbs	
	@Select("select * from posts order by id desc")
	List<BbsDto> findAll();

	@Select("select count(*) from posts")
	public Integer countBbs();

	@Select("select id, name, title, content from posts where id=#{id}")
	public BbsDto getBbs(Long id); // view 글내용

	@Insert("insert into posts (name, title, content) values (#{name},#{title}, #{content})")
	void createBbs(BbsDto req);

	@Delete("delete from posts where id=#{id}")
	public int deleteBbs(Long id);

	@Update("update posts set name=#{name}, title=#{title}, content=#{content} where id=#{id}")
	public int updateBbs(BbsDto req);
}
