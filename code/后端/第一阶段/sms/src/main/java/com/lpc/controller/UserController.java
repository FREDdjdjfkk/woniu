package com.lpc.controller;

import com.lpc.Service.UserServiceImpl;
import com.lpc.mapper.UserMapper;
import com.lpc.pojo.Products;
import com.lpc.pojo.Users;

import java.util.List;


public class UserController {
    UserServiceImpl userService=new UserServiceImpl();
    public Users selectByTelphone(String telphone){
        return userService.selectByTelphone(telphone);
    }


    public void changeMoney(Users users,double total){
        double remainmoney=userService.changeMoney(users,-total);
        System.out.println("支付："+total+"元，余额为："+remainmoney+"元");
    }

}
