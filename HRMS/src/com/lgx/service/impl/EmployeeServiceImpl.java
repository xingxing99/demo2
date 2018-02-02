package com.lgx.service.impl;

import com.lgx.dao.EmployeeMapper;
import com.lgx.model.Employee;
import com.lgx.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public Employee selectEmployeeByUid(int uid) {
        return employeeMapper.selectEmployeeByUid(uid);
    }

    @Override
    public List<Employee> selectEmployeeByPid(int pid) {
        return employeeMapper.selectEmployeeByPid(pid);
    }

    @Override
    public boolean updateEmployeeState(Employee employee) {
        try {
            return employeeMapper.updateEmployeeState(employee);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateEmployeePid(Employee employee) {
        return employeeMapper.updateEmployeePid(employee);
    }
}
