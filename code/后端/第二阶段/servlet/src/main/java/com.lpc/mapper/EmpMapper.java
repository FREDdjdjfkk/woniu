package com.lpc.mapper;


import com.lpc.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmpMapper {

    @Select("SELECT * FROM emp")
    List<Emp> findAll();

    @Insert("INSERT INTO emp  VALUES (#{empno},#{ename},#{job},#{mgr},#{sal},#{comm},#{deptno},#{hiredate})")
    void insert(Emp emp);

    @Update("UPDATE emp SET ename=#{ename},job=#{job},mgr=#{mgr},sal=#{sal},comm=#{comm},deptno=#{deptno},hiredate=#{hiredate} WHERE empno=#{empno}")
    void update(Emp emp);

    @Delete("DELETE FROM emp WHERE empno=#{id}")
    void delete(@Param("id") int id);
}