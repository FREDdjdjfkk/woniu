package com.lpc.springboot;

import com.lpc.bean.Student;
import com.lpc.controller.DeptController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    private DeptController deptController;

    @Test
    void selectAllTest() {
        //查询所有员工信息
        deptController.findAll(1,3).forEach(System.out::println);
    }
}
