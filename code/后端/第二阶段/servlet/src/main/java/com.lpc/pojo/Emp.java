package com.lpc.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 员工类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    /**员工编号*/
    private Integer empno;
    /**员工姓名*/
    private String ename;
    /**职位名称*/
    private String job;
    /**上级编号*/
    private String mgr;
    /**工资*/
    private Double sal;
    /**补偿金*/
    private Double comm;
    /**部门编号*/
    private Integer deptno;
    /**入职时间*/
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date hiredate;

}