package com.mytest.dubbo.cm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mytest.dubbo.cm.service.QueryUserService;
import com.mytest.dubbo.model.User;

@Controller
public class TestDubboController {

	
	
	
	@Resource
	private QueryUserService queryUserService;
	
	
	@RequestMapping("getUser.htm")
	public void getUsers(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
//		List<User> users = queryUserService.getUsers("123");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		if(name ==null || name.isEmpty()){
			response.getWriter().print("用户名不能为空");
			return ;
		}
		
		User user  = 	queryUserService.getUsers(name);
		if(user!=null){
			response.getWriter().print(user);
		}else{
			response.getWriter().print("不存在的用户名："+name+",您可以调用createUser.htm?name=xxxx来创建用户");
		}
		
	}
	
	
	@RequestMapping("createUser.htm")
	public void createUser(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
//		List<User> users = queryUserService.getUsers("123");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		if(name ==null || name.isEmpty()){
			response.getWriter().print("用户名不能为空");
			return ;
		}
		User user  = 	queryUserService.getUsers(name);
		if(user == null){
			queryUserService.create(name);
			response.getWriter().print("新建成功："+name);
		}else{
			response.getWriter().print("用户名已存在！"+user);
		}
		
		return ;
		
	}
	
}
