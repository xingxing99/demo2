package com.lgx.controller;

import com.lgx.model.Resume;
import com.lgx.model.User;
import com.lgx.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @RequestMapping("selectResume")
    public String selectResume(HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        List<Resume> resumes = resumeService.selectResume(user.getId());
        if (resumes.size()!=0){
            session.setAttribute("user",user);
            session.setAttribute("resumes",resumes);
            return "resume";
        }
        session.setAttribute("r1","没有简历，请添加");
        return "tourist";
    }
}
