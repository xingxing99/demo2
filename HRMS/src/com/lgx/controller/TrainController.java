package com.lgx.controller;

import com.lgx.model.Employee;
import com.lgx.model.Post;
import com.lgx.model.Train;
import com.lgx.service.DeptService;
import com.lgx.service.EmployeeService;
import com.lgx.service.PostService;
import com.lgx.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TrainController {
    @Resource
    private TrainService trainService;
    @Resource
    private PostService postService;
    @Resource
    private EmployeeService employeeService;
    @RequestMapping("selectTrain")
    public String selectTrain(HttpSession session)throws Exception{
        List<Train> trains = trainService.getAllTrain();
        if (trains.size()!=0){
            session.setAttribute("trains",trains);
            return "admin/train";
        }else{
            session.setAttribute("info","没有培训内容,请添加");
            return "admin/train";
        }
    }

    @RequestMapping("jumpAddTrain")
    public String jumpAddTrain()throws Exception{
        return "admin/addTrain";
    }

    @RequestMapping("addTrain")
    public String addTrain(Train train,HttpSession session)throws Exception{
        train.setState(0);
        trainService.addTrain(train);
        session.setAttribute("info","添加成功");
        session.setAttribute("trains",trainService.getAllTrain());
        return "admin/train";
    }

    @RequestMapping("deleteTrain")
    public String deleteTrain(Train train,HttpSession session,int state)throws Exception {
        if (state == 1) {
            session.setAttribute("info", "删除失败，培训已有员工参加");
            return "admin/train";
        } else {
            if (trainService.deleteTrain(train)) {
                session.setAttribute("info", "删除成功");
                session.setAttribute("trains", trainService.getAllTrain());
                return "admin/train";
            }
        }
        return "null";
    }
    @RequestMapping("updateTrain")
    public String updateTrain(int state,Train train,HttpSession session)throws Exception{
        if (state == 1) {
            session.setAttribute("info", "更改失败，培训已有员工参加");
            return "admin/train";
        }else{
            if (trainService.updateTrain(train)){
                session.setAttribute("info", "更改成功");
                session.setAttribute("trains", trainService.getAllTrain());
                return "admin/train";
            }
        }
        return "null";
    }

    @RequestMapping("arrangeTrain")
    public String arrangeTrain(int did,HttpSession session)throws Exception{
        session.setAttribute("did",did);
        session.setAttribute("trains",trainService.getAllTrain());
        return "admin/selectTrain";
    }

    @RequestMapping("arrangeTrain1")
    public String arrangeTrain1(int did,int id,String beginTime)throws Exception {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date1 = sdf.parse(beginTime);
        if (date.getTime() < date1.getTime()) {
            List<Post> posts = postService.selectPostByDid(did);
            for (Post post : posts) {
                List<Employee> employees = employeeService.selectEmployeeByPid(post.getId());
                for (Employee employee : employees) {
                    if (employee.getTid()==0){
                        employee.setTid(id);
                        employee.setId(employee.getId());
                        employeeService.updateEmployeeTid(employee);
                        return "admin/homepage";
                    }
                }
            }
        }
        return "null";
    }
}
