package com.mytest.jutil;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mytest.dubbo.model.User;
import com.mytest.dubbo.provider.ProviderUserService;  
  
public class Consumer {  
  
    public static void main(String[] args) throws Exception {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(  
                new String[] { "context/dubbo-cm.xml" });  
        context.start();  
  
        ProviderUserService demoService = (ProviderUserService) context.getBean("providerUserService");  
//        String hello = demoService.sayHello("daiderong");  
//        System.out.println(hello);  
  
        long star = System.currentTimeMillis();
//        for(int i=0;i<1000;i++){
//        	 List<User> list = demoService.getUsers("daiderong"); 
//        	 System.out.println(list);
//        }
        
       	 User user = demoService.getByName("daiderong");
       	 System.out.println(user);
       
        long end = System.currentTimeMillis();
        System.out.println("used time:"+(end-star));
        		
//        if (list != null && list.size() > 0) {  
//            for (int i = 0; i < list.size(); i++) {  
//                System.out.println(list.get(i));  
//            }  
//        }  
        
//        System.in.read();  
    }  
  
}  