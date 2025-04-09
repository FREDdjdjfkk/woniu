package com.lpc.mapper;

import com.lpc.bean.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门信息
     */
    @Select("select * from department")
    List<Dept> selectAll();

}