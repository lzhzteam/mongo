package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BDT.BDT;
import com.achd.mongo.Service.BDT_Repository;
import com.achd.mongo.Service.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.achd.mongo.Utilities.Utility.injectUser;

@Controller
public class IndexController {

    @Autowired
    private BDT_Repository BDTRepository;

    @Autowired
    private User_Repository user_repository;


    @RequestMapping(value = "/BDT")
    public List<BDT> getAllBDT() {
        return BDTRepository.findAll();
    }


    @GetMapping("/")
    public String getIndex(HttpSession session, Model model) {

        injectUser(session, model);


        return "index";
    }

    @GetMapping("/BDTInsert")
    public String getBDTInsert(HttpSession session, Model model) {
        injectUser(session, model);
        return "bdtinsert";
    }

    @GetMapping("/CCTAInsert")
    public String getCCTAInsert(HttpSession session, Model model) {

        injectUser(session, model);
        return "cctainsert";
    }
}