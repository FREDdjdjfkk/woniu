package com.lpc.service;


import com.lpc.pojo.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getAll();
    void add(Emp emp);
    void update(Emp emp);
    void delete(int id);
}