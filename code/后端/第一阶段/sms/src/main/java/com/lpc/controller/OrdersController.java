package com.lpc.controller;

import com.lpc.Service.OderSeviceImpl;
import com.lpc.pojo.Orders;

import java.util.List;

public class OrdersController {
    OderSeviceImpl oderSevice=new OderSeviceImpl();
    public List<Orders> selectByuid(Integer uid){
        return oderSevice.selectByuid(uid);
    }
    public Integer addorder(Integer uid,double total){return oderSevice.addorder(uid,total);}
    public void addorderitem(Integer order_id,Integer product, Integer quantity,double price){oderSevice.addorderitem(order_id,product,quantity,price);}

    public Orders selctByoid(Integer oid){return oderSevice.selectByoid(oid);}
}
