package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BDT.BDT;
import com.achd.mongo.Entity.BDT.BDT_Sub.BDTS;
import com.achd.mongo.Service.BDT_Repository;
import com.achd.mongo.Utilities.RequireAuth;
import com.achd.mongo.Utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.achd.mongo.Utilities.Utility.injectUser;

@Controller
public class BDTController {
    @Autowired
    BDT_Repository bdt_repository;

    @RequireAuth
    @GetMapping("/BDTInsert")
    public String get_BDTInsert(HttpSession session, Model model) {
        injectUser(session, model);
        return "bdtinsert";
    }

    @RequireAuth
    @PostMapping("/BDTInsert")
    @ResponseBody
    public BDT post_BDTInsert(BDT bdt, HttpSession session, Model model) {
        BDT hadUser = bdt_repository.findBDTBy编号(bdt.get编号());
        if (hadUser == null) {
            bdt_repository.save(bdt);
        } else {
            List<BDTS> hadUserBDTs = hadUser.getBDTs();
            hadUserBDTs.add(bdt.getBDTs().get(0));
            bdt_repository.save(hadUser);
        }
        return bdt;
    }

    @RequireAuth
    @GetMapping("/BDTSearch")
    public String get_CaseSearch(HttpSession session, Model model) {

        Utility.injectUser(session, model);
        model.addAttribute("type", "BDT");

        return "CaseSearch";
    }


    @RequireAuth
    @GetMapping("/BDTSearch/{search}")
    public String get_CaseSearch_result(HttpSession session, Model model, @PathVariable("search") String search) {
        Utility.injectUser(session, model);

        List<BDT> byId = bdt_repository.findBy编号ContainsOr姓名ContainsAllIgnoreCase(search, search);

        model.addAttribute("BDTList", byId);
        return "BDTSearchResult";
    }

}
