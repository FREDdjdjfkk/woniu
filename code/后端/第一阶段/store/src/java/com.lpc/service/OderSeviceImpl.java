package com.lpc.Service;

import com.lpc.mapper.OrdersMapper;
import com.lpc.pojo.Orders;
import com.lpc.util.MyBatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OderSeviceImpl {
    SqlSession sqlSession= MyBatisUtils.getsqlsession();
    OrdersMapper ordersMapper=sqlSession.getMapper(OrdersMapper.class);
    public List<Orders> selectByuid(Integer uid){
        return ordersMapper.selectByuid(uid);
    }

    public int addorder(Integer uid,double total){
        Orders order = new Orders();
        order.setUser_id(uid);
        order.setTotal_amount(total);
        ordersMapper.addOrder(order);
        sqlSession.commit();
        return order.getOrder_id();
    }
    public void addorderitem(Integer order_id,Integer product, Integer quantity,double price){
        ordersMapper.addOrderItem(order_id,product,quantity,price);
        sqlSession.commit();
    }
    public Orders selectByoid(Integer oid){return ordersMapper.selectByOrderId(oid);}

}
