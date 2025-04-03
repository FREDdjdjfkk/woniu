package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Orders;
import pojo.TUser;

public interface TUserMapper {

 public TUser getdetails(Integer id);

 public TUser findbyid(Integer id);

 @Select("select * from t_user where uname=#{uname}" )
 @Results({
         @Result(id=true, property = "uid", column = "uid"),
         @Result(property = "username", column = "uname"),

         @Result( column="telphone",property="telephone"),
         @Result(property = "ordersList", column = "uid",
                 many = @Many(select = "mapper.OrdersMapper.seOrder"))
 })
 public TUser selectusers(String name);
 @Select("SELECT * FROM t_user WHERE uid=#{uid}")
 @Results({
         @Result(id = true, property = "uid", column = "uid"),
         @Result(property = "username", column = "uname"),
         @Result(property = "password", column = "password"),
         @Result(property = "email", column = "email"),
         @Result(property = "telephone", column = "telphone"),

         // 通过用户ID关联查询用户的所有订单
         @Result(property = "ordersList", column = "uid",
                 many = @Many(select = "mapper.OrdersMapper.selectOrders"))
 })
 TUser getUserWithProducts(@Param("uid") Integer uid);


}
