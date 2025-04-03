package com.lpc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart_items {
    private Integer cart_item_id;
    private Integer user_id;
    private Integer product_id;
    private Integer quantity;
    private Date created_at;

    private String product_name;   // 商品名称
    private double price;      // 商品单价（从 products 表获取）
    private double total_price; // 计算字段（quantity * price）


    public Cart_items(Integer cart_item_id, Integer user_id, Integer product_id, Integer quantity, Date created_at) {
        this.cart_item_id = cart_item_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.created_at = created_at;
    }
}
