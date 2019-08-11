//package com.achd.mongo.Controller;
//
//import com.achd.mongo.Entity.BaseEntity;
//import com.achd.mongo.Service.BaseEntity_Repository;
//import com.achd.mongo.Service.User_Repository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//import static com.achd.mongo.Utilities.Utility.injectUser;
//
//@Controller
//public class IndexController {
//
//    @Autowired
//    private BaseEntity_Repository baseEntity_repository;
//
//    @Autowired
//    private User_Repository user_repository;
//
//
//    @RequestMapping(value = "/BDT")
//    @ResponseBody
//    public List<BaseEntity> getAllBDT() {
//        return baseEntity_repository.findAll();
//    }
//
//
//    @GetMapping("/")
//    public String getIndex(HttpSession session, Model model) {
//
//        injectUser(session, model);
//
//
//        return "index";
//    }
//
//
//
//}
