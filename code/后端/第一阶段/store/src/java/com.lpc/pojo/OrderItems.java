package com.lpc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    private Integer order_item_id;
    private Integer order_id;
    private Integer product_id;
    private Integer quantity;
    private Double price;
    private Date created_at;
    private Products product;

}
