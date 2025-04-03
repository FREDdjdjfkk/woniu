package com.lpc.mapper;

import com.lpc.pojo.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductsMapper {
    @Select("SELECT p.product_id, p.name AS product_name, p.description, p.price, p.stock, " +
            "c.category_id AS c_category_id, c.name AS c_name " +
            "FROM products p " +
            "LEFT JOIN categories c ON c.category_id = p.category_id")
    @Results({
            @Result(property = "product_id", column = "product_id"),
            @Result(property = "name", column = "product_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price"),
            @Result(property = "stock", column = "stock"),

            @Result(property = "categories.category_id", column = "c_category_id"),
            @Result(property = "categories.cname", column = "c_name")
    })
    public List<Products> showAllproducts();
    @Select("select * from products where description like ‘%#{des}%’ ")
    public Products selectBydescription(String des);
    @Select("select * from products where product_id=#{product_id}")
    public Products findByid(String  product_id);

    @Update("update products set stock=stock-#{num} where product_id=#{product_id}")
    public int updateStock(@Param("product_id") Integer product_id,@Param("num") int num);
}
