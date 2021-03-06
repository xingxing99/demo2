package com.lgx.dao;

import com.lgx.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    boolean addEmployee(Employee employee);
    Employee selectEmployeeByUid(int uid);
    List<Employee> selectEmployeeByPid(int pid);
    boolean updateEmployeeState(Employee employee);
    boolean updateEmployeePid(Employee employee);
    boolean updateEmployeeTid(Employee employee);
}
