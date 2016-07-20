package com.mytest.dubbo.cm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mytest.dubbo.cm.service.QueryUserService;
import com.mytest.dubbo.model.User;
import com.mytest.dubbo.provider.ProviderUserService;



@Service
public class QueryUserServiceImpl implements QueryUserService {

	@Resource
	private ProviderUserService providerUserService;
	
	
	public User getUsers(String name) {
		return providerUserService.getByName(name);
	}


	@Override
	public boolean create(String name) {
		 providerUserService.insertUser(name, System.currentTimeMillis()+"");
		 return true;
	}

}
