package com.lgx.controller;

import com.lgx.model.Post;
import com.lgx.model.Resume;
import com.lgx.model.User;
import com.lgx.service.DeptService;
import com.lgx.service.PostService;
import com.lgx.service.RecruitService;
import com.lgx.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private PostService postService;
    @RequestMapping("selectResume")
    public String selectResume(HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        Resume resumes = resumeService.selectResume(user.getId());
        if (resumes!=null){
            session.setAttribute("user",user);
            session.setAttribute("resumes",resumes);
            return "resume";
        }else {
            session.setAttribute("r1","没有简历，请添加");
            return "resume";
        }
    }

    @RequestMapping("addResume")
    public String addResume()throws Exception{
        return "addResume";
    }

    @RequestMapping("addResume1")
    public String addResume1(Resume resume,HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        resume.setUid(user.getId());
        resume.setRid(0);
        resume.setCreateTime(new Date());
        if (resumeService.addResume(resume)){
            return "tourist";
        }
        session.setAttribute("t1","添加简历失败");
        return "tourist";
    }

    @RequestMapping("updateResume")
    public String updateResume(HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        Resume resumes = resumeService.selectResume(user.getId());
        session.setAttribute("resumes",resumes);
        return "updateResume";
    }

    @RequestMapping("updateResume1")
    public String updateResume1(Resume resume, HttpSession session)throws Exception{
        if (resumeService.updateResume(resume)){
            User user = (User) session.getAttribute("user");
            Resume resumes = resumeService.selectResume(user.getId());
            session.setAttribute("resumes",resumes);
            return "resume";
        }else{
            session.setAttribute("r2","修改失败");
            return "resume";
        }
    }

    @RequestMapping("updateResumeState")
    public String updateResumeState(int rid,HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        Resume resumes = resumeService.selectResume(user.getId());
        if (resumes==null){
            return "addResume";
        }else{
            if (resumes.getState()!=0){
                session.setAttribute("r8","你已申请过职位，请不要重复申请");
                return "tourist";
            }else{
                resumes.setRid(rid);
                resumes.setState(1);
                resumeService.updateResumeState(resumes);
                session.setAttribute("r8","申请成功");
                return "tourist";
            }
        }
    }

    @RequestMapping("selectResumeByState")
    public String selectResumeByState(HttpSession session,Resume resume1)throws Exception{
        List<Resume> resume = resumeService.selectResumeByState(1,3);
        if (resume.size()!=0){
            session.setAttribute("resumes",resume);
            session.setAttribute("recruit",recruitService.selectRecruit());
            List<Post> posts =postService.selectPost();
            session.setAttribute("posts",posts);
            return "admin/resume";
        }else{
            session.setAttribute("r1","没有职位申请");
            return "admin/homepage";
        }
    }

    @RequestMapping("inform")
    public String inform(HttpSession session,int uid,String interview)throws Exception{
        Resume resume = resumeService.selectResume(uid);
        resume.setState(2);
        resume.setInterview(interview);
        if (resumeService.updateResumeState2(resume)){
            session.setAttribute("r10","通知成功");
            return "admin/homepage";
        }else{
            session.setAttribute("r10","通知不成功");
            return "admin/homepage";
        }
    }

    @RequestMapping("selectInform")
    public String selectInform(HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        Resume resume = resumeService.selectResume(user.getId());
        session.setAttribute("resume",resume);
        return "success";
    }

    @RequestMapping("acceptInterview")
    public String acceptInterview(HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        Resume resumes = resumeService.selectResume(user.getId());
        resumes.setState(3);
        resumes.setRid(resumes.getRid());
        if (resumeService.updateResumeState(resumes)){
            session.setAttribute("r99","接受成功");
            return "tourist";
        }else{
            session.setAttribute("r99","接受不成功");
            return "tourist";
        }
    }

    @RequestMapping("cancelInterview")
    public String cancelInterview(HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        Resume resumes = resumeService.selectResume(user.getId());
        resumes.setState(0);
        resumes.setRid(0);
        if (resumeService.updateResumeState(resumes)){
            session.setAttribute("r99","取消成功");
            return "tourist";
        }else{
            session.setAttribute("r99","取消不成功");
            return "tourist";
        }
    }
}
