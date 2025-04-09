package com.lpc.springboot;

import com.lpc.bean.Owner;
import com.lpc.controller.OwnerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OwnerTest {
    @Autowired
    OwnerController ownerController;
    @Autowired
    private Owner owner;
    @Test
    public void testAdd(){
        System.out.println(owner);
        ownerController.addOwner(owner);
        System.out.println("成功添加: "+owner);
    }
    @Test
    public void testDelete(){
        ownerController.deleteOwnerByName(owner.getUsername());
        System.out.println("删除成功");
    }
    @Test
    public void testModify(){
        ownerController.addOwner(owner);
        //可以添加由id查找
        owner.setUsername("lpc");
        ownerController.modifyOwnerById(owner);
        System.out.println(ownerController.findByConditions(1, 1, owner));

        ownerController.deleteOwnerByName(owner.getUsername());
    }
    @Test
    public void testSelect(){
        Owner owner1=new Owner();
        owner1.setSex("女");
        owner1.setIsDelete(0);
        ownerController.findByConditions(1,2,owner1).forEach(System.out::println);
    }
}
