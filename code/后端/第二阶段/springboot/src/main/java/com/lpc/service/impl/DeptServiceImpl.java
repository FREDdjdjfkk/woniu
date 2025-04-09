package com.lpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lpc.bean.Dept;
import com.lpc.mapper.DeptMapper;
import com.lpc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    //持有mapper引用
    @Autowired
    private DeptMapper deptMapper;

    /**
     *
     * @param pageNum  当前页
     * @param pageSize 每页记录数
     * @return 当前页面所有数据
     */
    @Override
    public List<Dept> selectAll(Integer pageNum, Integer pageSize) {
        //1.设置当前页和每页记录数
        PageHelper.startPage(pageNum, pageSize);
        //2.调用mapper方法查询所有部门信息
        List<Dept> depts = deptMapper.selectAll();
        //3.创建PageInfo对象
        PageInfo<Dept> info = new PageInfo<>(depts);
        info.getPageNum(); //获取当前页
        Integer size = info.getPageSize();//获取每页记录数
        info.getPages();//总页数
        long total = info.getTotal(); //总记录数
        //total / size == 0 ? total / size : (total / size) + 1
        //分页过后返回的数据
        return info.getList();
    }
}