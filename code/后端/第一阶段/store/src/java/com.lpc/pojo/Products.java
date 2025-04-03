package com.lpc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Products {
    private Integer product_id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Integer category_id;
    private Date created_at;
    private Date updated_at;
    private Categories categories;

}
