package com.lgx.service;

import com.lgx.model.Employee;

import java.util.List;

public interface EmployeeService {
    boolean addEmployee(Employee employee);
    Employee selectEmployeeByUid(int uid);
    List<Employee> selectEmployeeByPid(int pid);
    boolean updateEmployeeState(Employee employee);
    boolean updateEmployeePid(Employee employee);
    boolean updateEmployeeTid(Employee employee);
}
