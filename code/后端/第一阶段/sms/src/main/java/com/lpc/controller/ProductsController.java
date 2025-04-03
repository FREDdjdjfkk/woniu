package com.lpc.controller;

import com.lpc.Service.ProductsServiceImpl;
import com.lpc.pojo.Products;

import java.util.List;

public class ProductsController {
    ProductsServiceImpl productsServiceImpl=new ProductsServiceImpl();
    public List<Products> showAllproducts(){
        return productsServiceImpl.showAllproducts();
    }
    public Products selectBydes(String des){return productsServiceImpl.selectBydescription(des);}
    public Products findByid(String  pid){return productsServiceImpl.findByid(pid);}

    public int updateStock(Integer pid,int num){return productsServiceImpl.updateStock(pid,num);}
}
