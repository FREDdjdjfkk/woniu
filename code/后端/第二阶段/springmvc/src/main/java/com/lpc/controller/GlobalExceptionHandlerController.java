package com.lpc.controller;

import com.lpc.bean.User;
import com.lpc.util.ResultObj;
import com.lpc.util.UserNameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ex")
public class GlobalExceptionHandlerController {

    @RequestMapping("globalExceptionHandler")
    public ResultObj globalExceptionHandlerTest(){
        User user=new User(10086,"lpc","123");
        int i=10/0;
        return ResultObj.ok(user);
    }
    @RequestMapping("checkUserName")
    public ResultObj checkUserName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new UserNameNotFoundException("请求中未携带username");
        }
        return  ResultObj.ok(name);
    }
}
