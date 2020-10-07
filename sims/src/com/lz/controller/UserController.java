package com.lz.controller;

import com.lz.pojo.Student;
import com.lz.pojo.User;
import com.lz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String mcode, String mpassword, Model model, HttpSession session){
        User user = userService.findUser(mcode,mpassword);
        if(user != null){
            session.setAttribute("User",user);
            return "forward:selectAll";
        }
        model.addAttribute("msg","账号或密码错误，请重新输入！");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //清除session
        session.invalidate();
        //跳转到登录页面
        //重定向只支持get请求，请求转发只支持post请求，所以redirect:login只会调用toLogin()方法
        return "redirect:login";
    }
    //点击退出登录后，向用户登录页面跳转
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
}
