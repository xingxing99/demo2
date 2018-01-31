package com.lgx.controller;

import com.lgx.model.Dept;
import com.lgx.model.Employee;
import com.lgx.model.Post;
import com.lgx.service.EmployeeService;
import com.lgx.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class PostController {
    @Resource
    private PostService postService;
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("selectPost")
    public String selectPost(int did, HttpSession session)throws Exception{
        List<Post> posts = postService.selectPostByDid(did);
        if (posts.size()!=0){
            session.setAttribute("post",posts);
            return "admin/post";
        }
        return "admin/post";
    }

    @RequestMapping("addPost")
    public String addPost(int did,HttpSession session)throws Exception{
        session.setAttribute("did",did);
        return "admin/addPost";
    }

    @RequestMapping("addPost1")
    public String addPost1(int did,Post post,HttpSession session)throws Exception{
        if (postService.addPost(post)){
            List<Post> posts = postService.selectPostByDid(did);
            session.setAttribute("post",posts);
            return "admin/post";
        }else{
            session.setAttribute("p1","添加失败");
            return "admin/post";
        }
    }

    @RequestMapping("deletePost")
    public String deletePost(int id,HttpSession session,int did)throws Exception{
        List<Employee> employees = employeeService.selectEmployeeByPid(id);
        if (employees.size()!=0){
            return "admin/post";
        }else{
            postService.deletePostById(id);
            List<Post> posts = postService.selectPostByDid(did);
            session.setAttribute("post",posts);
            return "admin/post";
        }
    }

    @RequestMapping(value = "listPostByDeptId",method = RequestMethod.POST)
    public @ResponseBody Object[] listPostByDeptId(int deptId){
        List<Post> posts = postService.selectPostByDid(deptId);
        Object[] array = posts.toArray();
        return array;
    }
}
