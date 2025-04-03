package com.lpc.mapper;

import com.lpc.pojo.Cart_items;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Cart_itemsMapper {
    @Select("SELECT c.cart_item_id, c.user_id, c.product_id, c.quantity, " +
            "p.name AS product_name, p.price, (c.quantity * p.price) AS total_price, c.created_at " +
            "FROM cart_items c " +
            "JOIN products p ON c.product_id = p.product_id " +
            "WHERE c.user_id = #{uid}")
    @Results({
            @Result(property = "cart_item_id", column = "cart_item_id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "product_id", column = "product_id"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "product_name", column = "product_name"), // 新增商品名称
            @Result(property = "price", column = "price"),
            @Result(property = "total_price", column = "total_price"), // 新增单项商品总价
            @Result(property = "created_at", column = "created_at")
    })
    List<Cart_items> showAllcart_items(@Param("uid") Integer uid);


    @Insert("insert into cart_items values(#{cart_item_id},#{user_id},#{product_id},#{quantity},now())")
    public void  insertCartitems(Cart_items cartItems);

    @Update("update cart_items set quantity =quantity + #{quantity} where cart_item_id=#{cart_item_id} and user_id=#{uid}")
    public void updatequantities(@Param("quantity") Integer quantity,@Param("cart_item_id") Integer cart_item_id,@Param("uid") Integer uid);

    @Select("select * from cart_items where product_id=#{product_id} and user_id=#{user_id}")
    Cart_items getCartItemsByPidAndUid(@Param("product_id") Integer pid, @Param("user_id") Integer uid);


    @Delete("delete from cart_items where   product_id=#{pid} and user_id=#{uid}")
    void deleteByCart_item_id(@Param("pid")Integer pid,@Param("uid")Integer uid);
    @Select("select SUM(c.quantity * p.price) AS total_amount " +"from cart_items c "+"left join products p on c.product_id=p.product_id where c.user_id=#{uid}")
    public int sumall(@Param("uid") Integer uid);


}
