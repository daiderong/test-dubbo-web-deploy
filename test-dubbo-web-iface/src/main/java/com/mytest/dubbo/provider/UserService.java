package com.mytest.dubbo.provider;
  
import com.mytest.dubbo.model.User;  
  
public interface UserService {  
  
  
	/**
	 * 查询用户
	 * @param name
	 * @return
	 */
	public User getByName(String name);
	
	
	/**
	 * 插入一个用户
	 * @param name
	 * @param password
	 */
	public void insertUser(String name,String password);
  
}  