package com.lpc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component//创建对象交给spring容器进行管理
//使用@ConfigurationProperties执行前缀
//将配置文件中的属性自动绑定到java bean中
@ConfigurationProperties(prefix = "stu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer sid;
    private String sname;
    private String telephone;

//    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;
    //引用熊猫类
    private Panda panda;

    private String[] likes;
    private List<String> cities;

    private Map<String, Object> details;



}
