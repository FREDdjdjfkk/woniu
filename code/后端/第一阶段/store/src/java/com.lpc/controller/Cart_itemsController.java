package com.lpc.controller;

import com.lpc.Service.Cart_itemServiceImpl;
import com.lpc.pojo.Cart_items;
import com.lpc.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Cart_itemsController {
    Cart_itemServiceImpl cartItemService=new Cart_itemServiceImpl();

    public List<Cart_items> showAllcart_items(Integer uid){
        return cartItemService.showAllcart_items(uid);
    }
    public void addCartitem(Cart_items cartItems){cartItemService.insertCartitems(cartItems);}
    public Cart_items getCartItemsByPidAndUid(Integer pid, Integer uid){
        return cartItemService.getCartItemsByPidAndUid(pid, uid);
    }
    public void updatequantities(Integer num,Integer id,Integer uid){
        cartItemService.updatequantitier(num,id,uid);
    }
    public void deleteBycart_item_id(Cart_items cartItems){
        int pid=cartItems.getProduct_id();
        int uid=cartItems.getUser_id();
        cartItemService.deleteBycart_item_id(pid,uid);}

    public int sumall(Integer uid){return cartItemService.sumall(uid);}
}
