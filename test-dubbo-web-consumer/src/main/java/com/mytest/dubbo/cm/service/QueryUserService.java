package com.mytest.dubbo.cm.service;

import com.mytest.dubbo.model.User;

public interface QueryUserService {

	
	
	/**
	 * 查询用户
	 * @param name
	 * @return
	 */
	public User getUsers(String name);
	
	
	/**
	 * 查询用户
	 * @param name
	 * @return
	 */
	public boolean create(String name);
	
	
	
	
}
