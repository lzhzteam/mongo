package com.achd.mongo.Controller;

import com.achd.mongo.Entity.User;
import com.achd.mongo.Service.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    User_Repository user_repository;


    @GetMapping("/logIn")
    public String loginGet(HttpSession session, Model model) {
        if (session.getAttribute("uid") != null) {                           //如果已经登陆
            return "redirect:/";
        }


        String reason = (String) session.getAttribute("logFailure");//拿取loginFailure属性
        if (reason == null) {
            reason = "";
        }

        session.removeAttribute("logFailure");//移除loginFailure属性
        model.addAttribute("log", "In"); //指明是登录
        model.addAttribute("logFailure", reason);//向模板中注入属性
        return "logIn";//返回渲染的静态网页
    }


    @PostMapping("/logIn")
    public String logInPost(User user, HttpSession session, Model model) {
        User hadUser = user_repository.findByUsername(user.getUsername());   //通过username查找用户
        if (hadUser == null) {                                               //如果数据库按照username没查到这个用户
            session.setAttribute("logFailure", "null_user");   //向session里放置loginFailure=null_user这样一个属性
            return "redirect:/logIn";                                          //扔回去重新登陆
        } else if (!hadUser.getPasswordMD5().equals(user.getPasswordMD5())) {
            session.setAttribute("logFailure", "wrong_password");  //密码错误
            return "redirect:/logIn";                                            //扔回去重新登陆
        } else if (hadUser.getPasswordMD5().equals(user.getPasswordMD5())) {
            session.setAttribute("uid", hadUser.getId());              //密码正确
        }
        return "redirect:/";
    }


    @GetMapping("/logUp")
    public String logUpGet(HttpSession session, Model model) {

        String reason = (String) session.getAttribute("logFailure");

        if (reason == null) {
            reason = "";
        }

        model.addAttribute("log", "Up"); //表明是注册
        model.addAttribute("logFailure", reason);
        return "login";
    }


    @PostMapping("/logUp")
    public String logUpPost(User user, HttpSession session, Model model) {
        User hadUser = user_repository.findByUsername(user.getUsername());

        if (hadUser != null) {                                                   //用户名占用了
            session.setAttribute("logFailure", "had_user");
            return "redirect:/logUp";
        } else {
            user_repository.save(user);                                         //成功注册
            User newUser = user_repository.findByUsername(user.getUsername());
            session.setAttribute("uid", newUser.getId());
            return "redirect:/";
        }
    }
}
