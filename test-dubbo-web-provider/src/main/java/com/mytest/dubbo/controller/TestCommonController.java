package com.mytest.dubbo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mytest.dubbo.model.User;
import com.mytest.dubbo.provider.UserService;


/**
 * 本地调用的service用来测试与调用dubbo远程service的性能差别
 * @author daiderong
 *
 */
@Controller
public class TestCommonController {

	
	

	@Resource
	private UserService userService;
	
	
	@RequestMapping("getUser.htm")
	public void getUsers(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
//		List<User> users = queryUserService.getUsers("123");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		if(name ==null || name.isEmpty()){
			response.getWriter().print("用户名不能为空");
			return ;
		}
		
		User user  = 	userService.getByName(name);
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
		User user  = 	userService.getByName(name);
		if(user == null){
			userService.insertUser(name, System.currentTimeMillis()+"");
			response.getWriter().print("新建成功："+name);
		}else{
			response.getWriter().print("用户名已存在！"+user);
		}
		
		return ;
		
	}
	
}
