package com.lpc.service;

import com.lpc.bean.Owner;

import java.util.List;

public interface OwnerService {
    public void addOwner(Owner owner);
    public void deleteOwnerByName(String username);
    public void modifyOwnerById(Owner owner);
    List<Owner> findByUsernameAndSex(Integer pageNum, Integer pageSize,String username,
                                      String sex);
    List<Owner> findByConditions(Integer pageNum, Integer pageSize,Owner owner);
}
