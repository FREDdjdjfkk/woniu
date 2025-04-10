package com.lpc.controller;

import com.lpc.bean.User;
import com.lpc.util.ResultObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("res")
public class ResultController {
    //使用result实体类封装响应数据
    @RequestMapping("resultobj")
    @ResponseBody
    public ResultObj resultObj(){
        User user =new User(100,"npc","123");
        return ResultObj.ok(user);
    }
//使用map集合封装响应数据
    @RequestMapping("result")
    @ResponseBody
    public Map<String,Object> resuiltmap(){
        Map<String,Object> res=new HashMap<>();
        User user =new User(100,"npc","123");
        res.put("code",200);
        res.put("msg","请求成功");
        res.put("success","true");
        res.put("data",user);
        return res;
    }

}
