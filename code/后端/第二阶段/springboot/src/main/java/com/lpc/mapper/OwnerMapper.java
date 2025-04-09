package com.lpc.mapper;

import com.lpc.bean.Owner;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OwnerMapper {
    @Insert("insert into owner values(#{id},#{username},#{tel},#{sex},#{identity},#{house_id},#{remarks},#{password},#{isDelete},#{deltime})")
    public void addOwner(Owner owner);
    @Delete("delete from owner where username = #{username}")
    public void deleteOwnerByName(String username);

    @Update("update owner set username=#{username},tel=#{tel},sex=#{sex},identity=#{identity},house_id=#{house_id},remarks=#{remarks},password=#{password},idDelete=#{isDelete},deltime=#{deltime} where id=#{id}")
    public void modifyOwnerById(Owner owner);

    //这是精准查找，不适合分页查找
    @Select("SELECT * FROM owner WHERE username = #{username} AND sex = #{sex}")
    List<Owner> findByUsernameAndSex(@Param("username") String username,
                                     @Param("sex") String sex);

    List<Owner> findByConditions(Owner owner);
}
