package com.lpc.controller;

import com.lpc.bean.Owner;
import com.lpc.service.impl.OwnerImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OwnerController {
    @Resource
    private OwnerImpl ownerserviceimpl;

    public void addOwner(Owner owner){
        ownerserviceimpl.addOwner(owner);
    }
    public void deleteOwnerByName(String username){
        ownerserviceimpl.deleteOwnerByName(username);
    }
    public void modifyOwnerById(Owner owner){
        ownerserviceimpl.modifyOwnerById(owner);
    }
    List<Owner> findByUsernameAndSex(Integer pageNum, Integer pageSize, String username,
                                     String sex){
       return  ownerserviceimpl.findByUsernameAndSex(pageNum, pageSize, username, sex);
    }
    public List<Owner> findByConditions(Integer pageNum, Integer pageSize, Owner owner){
        return ownerserviceimpl.findByConditions(pageNum, pageSize, owner);
    }
}
