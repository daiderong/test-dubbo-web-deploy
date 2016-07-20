package com.mytest.dubbo.db.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.mytest.dubbo.model.User;

public interface UserMapper {

	@Select("SELECT * from user where username=#{username}")
	User getUser(String username);
	
	
	
	@Insert("INSERT INTO user values(#{username},#{password})")
	void insertUser(User user);
	
}