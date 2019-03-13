package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BDT.BDT;
import com.achd.mongo.Service.BDT_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import static com.achd.mongo.Utilities.Utility.injectUser;

@Controller
public class InsertController {

    @Autowired
    BDT_Repository bdt_repository;

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


    @PostMapping("/BDTInsert")
    @ResponseBody
    public String BDTInsertPost(BDT bdt, HttpSession session, Model model) {
        bdt_repository.findBDTByNum(bdt.getNum())
    }
}
