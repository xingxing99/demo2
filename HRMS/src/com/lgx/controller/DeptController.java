package com.lgx.controller;

import com.lgx.model.Dept;
import com.lgx.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DeptController {
    @Resource
    private DeptService deptService;

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
    public String addDept()throws Exception{
        return "";
    }
}
