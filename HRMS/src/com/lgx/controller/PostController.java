package com.lgx.controller;

import com.lgx.model.Dept;
import com.lgx.model.Post;
import com.lgx.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostController {
    @Resource
    private PostService postService;

    @RequestMapping("selectPost")
    public String selectPost(int did, HttpSession session)throws Exception{
        List<Post> posts = postService.selectPostByDid(did);
        if (posts.size()!=0){
            session.setAttribute("post",posts);
            return "admin/post";
        }
        return "admin/post";
    }
}
