package com.lgx.controller;

import com.lgx.model.Train;
import com.lgx.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TrainController {
    @Resource
    private TrainService trainService;

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
}
