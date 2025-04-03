package com.lpc.mapper;

import com.lpc.pojo.Products;
import com.lpc.pojo.Users;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from users where phone_number=#{telphone}")
    public Users selectByTelphone(@Param("telphone")String telphone);

    @Update("update users set money=money+#{totalMoney} where user_id=#{user_id}")
    public  void changeMoney(@Param("totalMoney")double money,@Param("user_id")double user_id);
}
