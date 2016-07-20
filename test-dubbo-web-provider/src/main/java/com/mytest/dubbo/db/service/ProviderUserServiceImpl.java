package com.mytest.dubbo.db.service;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.mytest.dubbo.db.dao.UserMapper;
import com.mytest.dubbo.model.User;
import com.mytest.dubbo.provider.ProviderUserService;

@Service(value="providerUserService")
public class ProviderUserServiceImpl implements ProviderUserService {

	
//	@Resource(name="test-sqlSessionFactory")
//	private SqlSessionFactory sqlSessionFactory ;  
	
	@Resource(name="test-sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	
	
	@Override
	public User getByName(String name) {
		
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);  
		 User u = userMapper.getUser(name);
		 return u;
	}
//
//
//	@Override
//	public void insertRdTx(String name, String pwd) {
//		 System.out.println(">>>>>>>>>>>>>>>>insertRdTx>>>>>>>>>>>>>>>>BEGIN");
//		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
//		 User user = new User();
//		 user.setPassword(pwd);
//		 user.setUsername(name);
//		 userMapper.insertUser(user);
////		 int i = 10/0;//会使事务回滚
//		 System.out.println("<<<<<<<<<<<<<<<insertRdTx<<<<<<<<<<<<<<<END");
//	}
//
//
//	@Override
//	public void insertRnTx(String name, String pwd) {
//		 System.out.println(">>>>>>>>>>>>>>>>insertRnTx>>>>>>>>>>>>>>>>BEGIN");
//		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
//		 User user = new User();
//		 user.setPassword(pwd);
//		 user.setUsername(name);
//		 userMapper.insertUser(user);
////		 int i = 10/0;//会使事务回滚，有可能仅影响本
//		 System.out.println("<<<<<<<<<<<<<<<insertRnTx<<<<<<<<<<<<<<<END");
//		
//	}
//
//
//	
//	@Override
//	public void insert(String name, String pwd)  {
//		 System.out.println(">>>>>>>>>>>>>>>>insert>>>>>>>>>>>>>>>>BEGIN");
//		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
//		 User user = new User();
//		 user.setPassword(pwd);
//		 user.setUsername(name);
//		 userMapper.insertUser(user);
//		 //int  i = 10/0; //如果外层没有事务将不会使事务回滚，如果外层有事务会使事务回滚
//		 System.out.println("<<<<<<<<<<<<<<<insert<<<<<<<<<<<<<<<END");
//	}
//	
//	public void  insertInner(String name, String pwd)  {
//		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
//		 User user = new User();
//		 user.setPassword(pwd);
//		 user.setUsername(name);
//		 userMapper.insertUser(user);
//	}
//
//
//	@Override
//	public void testRdTx() {
//		insertRdTx("rdtx", "rdtx");
//		insert("innner", "12345");
//	}
//
//
//	@Override
//	public void testRnTx() {
//		insertRnTx("rntx", "rntx");
//		insert("innner", "12345");
//	}
//		



	@Override
	public void insertUser(String name, String password) {
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 User user = new User();
		 user.setPassword(password);
		 user.setUsername(name);
		 userMapper.insertUser(user);
	}

}
