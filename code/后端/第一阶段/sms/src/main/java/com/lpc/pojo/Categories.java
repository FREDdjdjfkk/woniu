package com.lpc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品分类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {

    /**编号*/
    private Integer category_id;
    /**名称*/
    private String cname;
    /**创建时间*/
    private String created_at;
    /**修改时间*/
    private String updated_at;

}
