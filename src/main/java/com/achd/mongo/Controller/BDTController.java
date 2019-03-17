package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BDT.BDT;
import com.achd.mongo.Entity.BDT.BDT_Sub.BDTS;
import com.achd.mongo.Service.BDT_Repository;
import com.achd.mongo.Utilities.RequireAuth;
import com.achd.mongo.Utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.achd.mongo.Utilities.Utility.injectUser;

@Controller
public class BDTController {
    @Autowired
    BDT_Repository bdt_repository;

    @RequireAuth
    @GetMapping("/BDTInsert")
    public String getBDTInsert(HttpSession session, Model model) {
        injectUser(session, model);
        return "bdtinsert";
    }

    @RequireAuth
    @PostMapping("/BDTInsert")
    @ResponseBody
    public BDT BDTInsertPost(BDT bdt, HttpSession session, Model model) {
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

    @RequestMapping(value = "/autoFillBDT", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> autoFillBDT(HttpServletRequest request, HttpServletResponse response) {
        String num = request.getParameter("num");
        BDT bdt = bdt_repository.findBDTBy编号(num);
        Map<String, Object> map = new HashMap<>();
        if (bdt == null) {
            map.put("exist", false);
        } else {
            map.put("exist", true);
            map.put("name", bdt.get姓名());
            map.put("gender", bdt.get性别());
        }
        return map;
    }

    @RequireAuth
    @GetMapping("/CaseSearch")
    public String caseSearchGet(HttpSession session, Model model) {

        Utility.injectUser(session, model);

        return "CaseSearch";
    }


    @RequireAuth
    @GetMapping("/CaseSearch/{search}")
    public String caseSearchResultGet(HttpSession session, Model model, @PathVariable("search") String search) {
        Utility.injectUser(session, model);

        List<BDT> byId = bdt_repository.findBy编号ContainsOr姓名ContainsAllIgnoreCase(search, search);

        model.addAttribute("BDTList", byId);
        return "CaseSearchResult";
    }

}
