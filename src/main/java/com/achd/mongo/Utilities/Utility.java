//package com.achd.mongo.Utilities;
//
//import com.achd.mongo.Entity.User;
//import org.springframework.ui.Model;
//
//import javax.servlet.http.HttpSession;
//
//public class Utility {
//    public static void injectUser(HttpSession session, Model model) {
//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            user = new User("1", "未登录", "000");
//        }
//        model.addAttribute("user", user);
//    }
//}
