package com.study.spring.store;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IStoreDao {
// store	
	@Select("select * from store order by id desc")
	List<StoreDto> findAll();

	@Select("select count(*) from store")
	public Integer countStore();

	@Select("select id, name, addr from store where id=#{id}")
	public StoreDto storeView(Long id); // view 글내용

	@Insert("insert into store (name,addr) values (#{name},#{addr})")
	void createStore(StoreDto req);

	@Delete("delete from store where id=#{id}")
	public int deleteStore(Long id);

//	menu
	@Select("select * from menu order by id desc")
	List<MenuDto> findMenuAll();

	@Select("select * from menu where id=#{id}")
	public MenuDto menuView(Long id); // view 글내용

	@Insert("insert into menu (name,price,store_id) values (#{name},#{price},#{store_id})")
	void createMenu(MenuDto req);

	@Select("select * from menu where store_id=#{store_id}")
	List<MenuDto> findMenuByStoreID(Long store_id);

	@Select("select * from store")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "addr", column = "addr"),
			@Result(property = "menus", column = "id", many = @Many(select = "findMenuByStoreID"))

	})
	List<StoreMenuDto> storeAndMenuAll();

	@Select("select * from menu")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "price", column = "price"),
			@Result(property = "store", column = "store_id", one = @One(select = "storeView"))

	})
	List<MenuStoreDto> menuAndStore();

//	@Select("select * from menu m join store s on s.id = m.store_id")
//	@Results({ @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
//			@Result(property = "price", column = "price"),
//			@Result(property = "store", column = "store_id"),
//			@Association(javaType = StoreDto.class, results = {
//					@Result(column = "id", property = "id"), @Result(column = "name", property = "name"),
//					@Result(column = "addr", property = "addr") })
//
//	})
//	List<MenuStoreDto> menuAndStoreJoin();

//	@Select("ALTER ROLE postgres SET pgaudit.log TO 'read, write, ddl'")
//	public String current_user();
}
