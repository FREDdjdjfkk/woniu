package com.lpc.Service;

import com.lpc.mapper.UserMapper;
import com.lpc.pojo.Products;
import com.lpc.pojo.Users;
import com.lpc.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class UserServiceImpl {
    SqlSession sqlSession= MyBatisUtils.getsqlsession();
    UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

    public Users selectByTelphone(String telphone){

        return userMapper.selectByTelphone(telphone);
    }

    public double changeMoney(Users users,double total){
        userMapper.changeMoney(total,users.getUser_id());
        sqlSession.commit();
        users=userMapper.selectByTelphone(users.getPhone_number());
        return users.getMoney();
    }


}
