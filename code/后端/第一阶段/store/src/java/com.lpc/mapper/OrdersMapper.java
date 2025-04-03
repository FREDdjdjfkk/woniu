package com.lpc.mapper;

import com.lpc.pojo.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersMapper {

    @Select("select * from orders where user_id=#{#uid}")
    public List<Orders> selectByuid(Integer uid);

    @Insert("insert into Orders values(null,#{user_id},#{total_amount},'pending',now(),now())")
    @Options(useGeneratedKeys = true, keyProperty = "order_id")
    public  void addOrder(Orders order);
    @Insert("insert into Order_items values(null,#{order_id},#{product_id},#{quantity},#{price},now())")
    public void addOrderItem(@Param("order_id")Integer order_id,@Param("product_id")Integer product,@Param("quantity")Integer quantity,@Param("price")double price);
    @Select("select * from orders where order_id=#{order_id}")

    Orders selectByOrderId(Integer order_id);

}
