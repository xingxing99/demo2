package com.lgx.controller;

import com.lgx.model.Dept;
import com.lgx.model.Employee;
import com.lgx.model.Post;
import com.lgx.model.Resume;
import com.lgx.service.DeptService;
import com.lgx.service.EmployeeService;
import com.lgx.service.PostService;
import com.lgx.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;
    @RequestMapping("addEmployee")
    public String addEmployee(int uid, int pid, Employee employee, HttpSession session)throws Exception{
        Resume resume = resumeService.selectResume(uid);
        resume.setState(4);
        resume.setRid(resume.getRid());
        employee.setName(resume.getName());
        employee.setSex(resume.getSex());
        employee.setAge(resume.getAge());
        employee.setState(1);
        employee.setPid(pid);
        employee.setUid(uid);
        employee.setTid(0);
        employee.setCreateTime(new Date());
        resumeService.updateResumeState(resume);
        employeeService.addEmployee(employee);
        session.setAttribute("r1","录取成功");
        return "admin/homepage";
    }
    
    @RequestMapping("updateEmmployeeState")
    public String updateEmmployeeState(int id,String explain,Employee employee)throws Exception{
        employee.setId(id);
        employee.setExplain(explain);
        if (employeeService.updateEmployeeState(employee)){
            return "admin/homepage";
        }
        return "null";
    }

    @RequestMapping("updateEmployee")
    public String updateEmployee(int pid, Employee employee, HttpServletRequest request,HttpSession session)throws Exception{
        int eid = Integer.parseInt(request.getParameter("eid"));
        employee.setId(eid);
        employee.setPid(pid);
        employeeService.updateEmployeePid(employee);
        List<Employee> employees = employeeService.selectEmployeeByPid(pid);
        session.setAttribute("employee",employees);
        return "admin/homepage";
    }
}
