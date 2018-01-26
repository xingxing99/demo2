package com.lgx.controller;

import com.lgx.model.User;
import com.lgx.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/register")
    public String register()throws Exception{
        return "register";
    }

    @RequestMapping(value = "/checkName",method = RequestMethod.POST)
    public @ResponseBody String checkName(User user) throws Exception{
        User user1 = userService.checkName(user);
        if (user1!=null){
            String str = "用户已存在";
            return str;
        }
        return "ok";
    }

    @RequestMapping("registerUser")
    public String registerUser(User user)throws Exception{
        if (userService.addUser(user)){
            return "../../index";
        }
        return "register";
    }
    @RequestMapping("login")
    public String login(User user, HttpSession session,int identity)throws Exception{
        if (user!=null){
            if (identity==0){
                User user1 = userService.selectUser(user);
                if (user1!=null){
                    session.setAttribute("user",user1);
                    return "tourist";
                }
            }else if(identity==1){

            }else{

            }
        }
        return "../../index";
    }
}