package com.lpc.service;

import com.lpc.bean.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门信息，进行分页
     * @param pageNum  当前页
     * @param pageSize 每页记录数
     * @return
     */
    List<Dept> selectAll(Integer pageNum, Integer pageSize);
}