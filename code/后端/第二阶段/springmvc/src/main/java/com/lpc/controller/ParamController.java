package com.lpc.controller;

import com.lpc.bean.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("param")
public class ParamController {
    @Autowired
    private ResultController resultController;
    @RequestMapping("param01")
    @ResponseBody
    public Map<String,Object> params01(HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();

        String uname=request.getParameter("uname");
        String pwd=request.getParameter("pwd");

        map.put("uname",uname);
        map.put("pwd",pwd);
        map.put("msg","请求成功");
        map.put("code",200);
        return map;
    }
    //形参

    @RequestMapping("param02")
    @ResponseBody
    public Map<String,Object> params02(String uname,String pwd){
        Map<String,Object> map=new HashMap<String,Object>();


        map.put("uname",uname);
        map.put("pwd",pwd);
        map.put("msg","请求成功");
        map.put("code",200);
        return map;
    }

    @RequestMapping("param03")
    @ResponseBody
    public Map<String,Object> params03(@RequestParam("username") String uname,@RequestParam(required=true,defaultValue="007") String pwd){
        Map<String,Object> map=new HashMap<String,Object>();


        map.put("uname",uname);
        map.put("pwd",pwd);
        map.put("msg","请求成功");
        map.put("code",200);
        return map;
    }


    @RequestMapping("param06")
    @ResponseBody
    public Map<String,Object> params06(@RequestBody User user){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("msg","请求成功");
        map.put("code",202);
        map.put("data",user);

        return map;
    }
}
