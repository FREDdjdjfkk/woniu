package com.lpc.controller;

import com.lpc.bean.Dept;
import com.lpc.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DeptController {

    //持有service层对象的引用
    @Resource
    private DeptService deptService;


    /**
     * 查询所有
     */
    public List<Dept> findAll(Integer pageNum, Integer pageSize){
        return deptService.selectAll(pageNum,pageSize);
    }
}