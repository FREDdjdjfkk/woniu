package com.lpc.Service;

import com.lpc.mapper.Cart_itemsMapper;
import com.lpc.pojo.Cart_items;
import com.lpc.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Cart_itemServiceImpl {
    SqlSession sqlSession= MyBatisUtils.getsqlsession();
    Cart_itemsMapper cartItemsMapper=sqlSession.getMapper(Cart_itemsMapper.class);
    public List<Cart_items> showAllcart_items(Integer uid){
        return cartItemsMapper.showAllcart_items(uid);
    }
    public void insertCartitems(Cart_items cartItems){ cartItemsMapper.insertCartitems(cartItems);sqlSession.commit();}
    public void updatequantitier(Integer num,Integer id,Integer uid){cartItemsMapper.updatequantities(num,id,uid);sqlSession.commit();}
   public Cart_items getCartItemsByPidAndUid(Integer pid, Integer uid) {
        return cartItemsMapper.getCartItemsByPidAndUid(pid,uid);
    }
    public void deleteBycart_item_id(Integer pid,Integer uid){cartItemsMapper.deleteByCart_item_id(pid,uid);sqlSession.commit();}

    public int sumall(Integer uid){return cartItemsMapper.sumall(uid);}


}
