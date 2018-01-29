package com.lgx.service;

import com.lgx.model.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> selectDept();
    boolean addDept(Dept dept);
}
