package com.lpc.service;

import com.lpc.mapper.EmpMapper;
import com.lpc.pojo.Emp;
import com.lpc.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
public class EmpServiceImpl implements EmpService {
    SqlSession sqlSession= MyBatisUtils.getsqlsession();
    private EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

    public List<Emp> getAll() {
        return mapper.findAll();
    }

    public void add(Emp emp) {
        mapper.insert(emp);
        sqlSession.commit();
    }

    public void update(Emp emp) {
        mapper.update(emp);
        sqlSession.commit();
    }

    public void delete(int id) {
        mapper.delete(id);
        sqlSession.commit();
    }
}