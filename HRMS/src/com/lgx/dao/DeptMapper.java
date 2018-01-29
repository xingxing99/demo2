package com.lgx.dao;

import com.lgx.model.Dept;

import java.util.List;

public interface DeptMapper {
    List<Dept> selectDept();
    boolean addDept(Dept dept);
}
