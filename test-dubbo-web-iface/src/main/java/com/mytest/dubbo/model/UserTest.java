package com.mytest.dubbo.model;

public class UserTest {


    public static void main(String[] args) {
        User u1 = new User();
        u1.setUsername("liuyou");
        u1.setAge(17);
        u1.setSex("M");
        u1.setPassword("1212121213123");

        User u2 = new User();
        u2.setUsername("liuyou");
        u2.setAge(17);
        u2.setSex("M");
        u2.setPassword("1212121213123123123");


        System.err.println(u1.equals(u2));


    }


}
