package com.lgx.service.impl;

import com.lgx.dao.DeptMapper;
import com.lgx.model.Dept;
import com.lgx.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> selectDept() {
        return deptMapper.selectDept();
    }

    @Override
    public boolean addDept(Dept dept) {
        try {
            return deptMapper.addDept(dept);
        } catch (Exception e) {
            return false;
        }
    }
}
