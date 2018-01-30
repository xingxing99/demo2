package com.lgx.controller;

import com.lgx.model.Post;
import com.lgx.model.Recruit;
import com.lgx.service.PostService;
import com.lgx.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class RecruitController {
    @Resource
    private RecruitService recruitService;
    @Resource
    private PostService postService;
    @RequestMapping("selectRecruit")
    public String selectRecruit(HttpSession session)throws Exception{
        List<Recruit> recruits = recruitService.selectRecruit();
        if (recruits.size()!=0){
            List<Post> posts =postService.selectPost();
            session.setAttribute("posts",posts);
            session.setAttribute("recruits",recruits);
            return "admin/recruit";
        }
        session.setAttribute("r2","没有招聘信息，请添加");
        return "admin/recruit";
    }

    @RequestMapping("addRecruit")
    public String addRecruit()throws Exception{
        return "admin/addRecruit";
    }

    @RequestMapping("addRecruit1")
    public String addRecruit1(Recruit recruit,HttpSession session)throws Exception{
        recruit.setCreateTime(new Date());
        recruit.setState(0);
        if (recruitService.addRecruit(recruit)){
            List<Recruit> recruits = recruitService.selectRecruit();
            session.setAttribute("recruits",recruits);
            return "admin/recruit";
        }
        return "admin/recruit";
    }

    @RequestMapping("updateRecruit")
    public String updateRecruit(int id,HttpSession session,Recruit recruit)throws Exception{
        recruit.setState(1);
        recruit.setId(id);
        if (recruitService.updateRecruit(recruit)){
            List<Recruit> recruits = recruitService.selectRecruit();
            session.setAttribute("recruits",recruits);
            return "admin/recruit";
        }
       return  "admin/recruit";
    }
    @RequestMapping("updateRecruit1")
    public String updateRecruit1(int id,HttpSession session,Recruit recruit)throws Exception{
        recruit.setState(0);
        recruit.setId(id);
        if (recruitService.updateRecruit(recruit)){
            List<Recruit> recruits = recruitService.selectRecruit();
            session.setAttribute("recruits",recruits);
            return "admin/recruit";
        }
        return  "admin/recruit";
    }

    @RequestMapping("getAllRecruit")
    public String getAllRecruit(HttpSession session)throws Exception{
        List<Recruit> recruits = recruitService.selectRecruit();
        if (recruits.size()!=0){
            List<Post> posts =postService.selectPost();
            session.setAttribute("posts",posts);
            session.setAttribute("recruits",recruits);
            return "recruit";
        }
        session.setAttribute("r2","没有招聘信息，请添加");
        return "recruit";
    }
}
