package com.mercer.controller;

import com.mercer.pojo.DevUser;
import com.mercer.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ Date:2019/4/14
 * Auther:Mercer
 * Auther:麻前程
 */
@Controller
@RequestMapping("/dev")
public class DevUserController{

    @Autowired
    DevUserService devUserService;
    @RequestMapping("toLogin")
    public String toLogin(){
        return "dev/login";
    }

    @RequestMapping("/login")
    public String login(DevUser user, Model model,HttpSession session){
        user= devUserService.login(user);
        if (user!=null){
            //登陆成功
            session.setAttribute("devUser",user);
            return "dev/index";
        }
        else{
            model.addAttribute("errMsg","登陆失败");
            return "dev/login";
        }

    }
//实现退出功能
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("devUser");
        session.invalidate();
        return "redirect:/index.jsp";
    }

}
