package com.lgx.controller;

import com.lgx.model.Dept;
import com.lgx.model.Employee;
import com.lgx.model.Post;
import com.lgx.service.DeptService;
import com.lgx.service.EmployeeService;
import com.lgx.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class DeptController {
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;
    @Resource
    private EmployeeService employeeService;
    @RequestMapping("selectDept")
    public String selectDept(HttpSession session)throws Exception{
        List<Dept> depts = deptService.selectDept();
        if (depts.size()!=0){
            session.setAttribute("depts",depts);
            return "admin/dept";
        }else{
            session.setAttribute("d1","请先创建部门");
            return "admin/dept";
        }
    }

    @RequestMapping("addDept")
    public String addDept(String dname,Dept dept,HttpSession session)throws Exception{
        dept.setDname(dname);
        dept.setCreateTime(new Date());
        if (deptService.addDept(dept)){
            List<Dept> depts = deptService.selectDept();
            session.setAttribute("depts",depts);
            return "admin/dept";
        }else{
            session.setAttribute("d1","添加失败");
            return "admin/dept";
        }
    }

    @RequestMapping("deleteDept")
    public String deleteDept(int did,HttpSession session)throws Exception{
        List<Post> posts = postService.selectPostByDid(did);
        boolean flag = false;
        for(Post post:posts){
            if (employeeService.selectEmployeeByPid(post.getId()).size()!=0){
                flag=true;
                break;
            }
        }
        if (flag){
            session.setAttribute("d1","删除失败,该部门下有员工");
            return "admin/dept";
        }else {
            if (deptService.deleteDept(did)) {
                postService.deletePostByDid(did);
                List<Dept> depts = deptService.selectDept();
                session.setAttribute("depts", depts);
                return "admin/dept";
            }else{
                session.setAttribute("d1","删除失败");
                return "admin/dept";
            }
        }
    }

    @RequestMapping("selectPostByPid")
    public String selectPostByPid(int pid,HttpSession session)throws Exception{
        List<Employee> employees = employeeService.selectEmployeeByPid(pid);
        if (employees.size()!=0){
            List<Dept> depts = deptService.selectDept();
            session.setAttribute("depts",depts);
            List<Post> posts = postService.selectPost();
            session.setAttribute("post",posts);
            session.setAttribute("employee",employees);
            return "admin/employee";
        }else{
            session.setAttribute("employee",employees);
            return "admin/employee";
        }
    }
}
