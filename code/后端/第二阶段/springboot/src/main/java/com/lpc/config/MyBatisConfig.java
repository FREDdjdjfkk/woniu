package com.lpc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.lpc.mapper")
public class MyBatisConfig {
}
