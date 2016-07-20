package com.mytest.dubbo.model;

import java.io.Serializable;

public class User implements Serializable {

	private Integer age;
	private String sex;
	private String username;
	private String password;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "用户名:"+username+",密码:"+password;
	}
	
}
