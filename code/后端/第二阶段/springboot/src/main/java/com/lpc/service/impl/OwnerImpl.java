package com.lpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lpc.bean.Owner;
import com.lpc.mapper.OwnerMapper;
import com.lpc.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerImpl implements OwnerService {
    @Autowired
    private OwnerMapper mapper;
    @Override
    public void addOwner(Owner owner) {
        mapper.addOwner(owner);
    }

    @Override
    public void deleteOwnerByName(String username) {
        mapper.deleteOwnerByName(username);
    }

    @Override
    public void modifyOwnerById(Owner owner) {
        mapper.modifyOwnerById(owner);
    }

    @Override
    public List<Owner> findByUsernameAndSex(Integer pageNum, Integer pageSize,String username, String sex) {
        PageHelper.startPage(pageNum,pageSize);
        List<Owner> owners=mapper.findByUsernameAndSex(username,sex);
        PageInfo<Owner> info=new PageInfo<>(owners);
        info.getPageNum();
        Integer size=info.getPageSize();
        info.getPages();
        long total=info.getTotal();
        return info.getList();
    }

    @Override
    public List<Owner> findByConditions(Integer pageNum, Integer pageSize,Owner owner) {
        PageHelper.startPage(pageNum,pageSize);
        List<Owner> owners=mapper.findByConditions(owner);
        PageInfo<Owner> info=new PageInfo<>(owners);
        info.getPageNum();
        Integer size=info.getPageSize();
        info.getPages();
        long total=info.getTotal();
        return info.getList();
    }
}
