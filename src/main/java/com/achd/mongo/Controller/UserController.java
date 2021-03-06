package com.achd.mongo.Controller;

import com.achd.mongo.Entity.User;
import com.achd.mongo.Service.User_Repository;
import com.achd.mongo.Utilities.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    User_Repository user_repository;
//
//
//    @GetMapping("/logIn")
//    public String loginGet(HttpSession session, Model model) {
//
//        injectUser(session, model);
//
//
//        String reason = (String) session.getAttribute("logFailure");//拿取loginFailure属性
//        if (reason == null) {
//            reason = "";
//        }
//
//        session.removeAttribute("logFailure");//移除loginFailure属性
//        model.addAttribute("log", "In"); //指明是登录
//        model.addAttribute("logFailure", reason);//向模板中注入属性
//        return "logIn";//返回渲染的静态网页
//    }
//
//
//    @PostMapping("/logIn")
//    public String logInPost(User user, HttpSession session, Model model) {
//        User hadUser = user_repository.findByUsername(user.getUsername());   //通过username查找用户
//        if (hadUser == null) {                                               //如果数据库按照username没查到这个用户
//            session.setAttribute("logFailure", "没有这个用户");   //向session里放置loginFailure=null_user这样一个属性
//            return "redirect:/logIn";                                          //扔回去重新登陆
//        } else if (!hadUser.getPasswordMD5().equals(user.getPasswordMD5())) {
//            session.setAttribute("logFailure", "密码错误");  //密码错误
//            return "redirect:/logIn";                                            //扔回去重新登陆
//        } else if (hadUser.getPasswordMD5().equals(user.getPasswordMD5())) {
//            session.setAttribute("user", hadUser);              //密码正确
//        }
//
//        String lastUrl = (String) session.getAttribute("lastUrl");
//
//        session.removeAttribute("lastUrl");
//
//        if (lastUrl != null) {
//            String[] t = lastUrl.split("_");
//            return "redirect:/" + t[1];
//        }
//        return "redirect:/";
//    }
//
//
//    @GetMapping("/logUp")
//    public String logUpGet(HttpSession session, Model model) {
//
//        injectUser(session, model);
//
//
//        String reason = (String) session.getAttribute("logFailure");
//
//        if (reason == null) {
//            reason = "";
//        }
//
//        model.addAttribute("log", "Up"); //表明是注册
//        model.addAttribute("logFailure", reason);
//        return "logIn";
//    }
//
//
//    @PostMapping("/logUp")
//    public String logUpPost(User user, HttpSession session, Model model) {
//        User hadUser = user_repository.findByUsername(user.getUsername());
//
//        if (hadUser != null) {                                                   //用户名占用了
//            session.setAttribute("logFailure", "had_user");
//            return "redirect:/logUp";
//        } else {
//            user_repository.save(user);                                         //成功注册
//            User newUser = user_repository.findByUsername(user.getUsername());
//            session.setAttribute("user", newUser);
//            return "redirect:/";
//        }
//    }
//
//
//    @RequestMapping("/logOff")
//    public String logOffReq(HttpSession session) {
//        session.removeAttribute("user");
//        return "redirect:/";
//    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User hadUser = user_repository.findByUsername(user.getUsername());   //通过username查找用户
        if (hadUser == null) {                                               //如果数据库按照username没查到这个用户
            return null;
        } else if (!hadUser.getPassword().equals(user.getPassword())) {
            return null;
        }

        hadUser.setPassword(null);
        return user;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody User user) {
        User hadUser =  user_repository.findByUsername(user.getUsername());
        if (hadUser == null)
            return false;

        user.setPassword(SecurityUtils.SHAEncryption(user.getPassword()));
        user_repository.insert(user);
        return true;
    }
}
