package com.lpc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "owner")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    private Integer id;             // 业主编号
    private String username;        // 业主姓名
    private String tel;             // 手机号码
    private String sex;             // 性别
    private String identity;        // 身份证
    private Integer houseId;        // 房屋ID
    private String remarks;         // 备注
    private String password;        // 密码
    private Integer isDelete;       // 是否删除（0-正常，1-删除）
    private java.util.Date deltime; // 删除时间
}
