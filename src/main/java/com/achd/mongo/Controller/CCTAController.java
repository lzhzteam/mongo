package com.achd.mongo.Controller;

import com.achd.mongo.Entity.CCTA.CCTA;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTAs;
import com.achd.mongo.Service.CCTA_Repository;
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
public class CCTAController {

    @Autowired
    CCTA_Repository ccta_repository;

    @RequireAuth
    @GetMapping("/CCTAInsert")
    public String get_CCTAInsert(HttpSession session, Model model) {
        injectUser(session, model);
        return "cctainsert";
    }

    @RequireAuth
    @PostMapping("/CCTAInsert")
    @ResponseBody
    public CCTA post_CCTAInsert(CCTA ccta, HttpSession session, Model model) {
        CCTA hadCCTA = ccta_repository.findCCTABy编号(ccta.get编号());
        if (hadCCTA == null) {
            ccta_repository.save(ccta);
        } else {
            List<CCTAs> hadUserCCTAs = hadCCTA.getCCTAs();
            hadUserCCTAs.add(ccta.getCCTAs().get(0));
            ccta_repository.save(hadCCTA);
        }

        return ccta;
    }

    @RequestMapping(value = "/autoFillCCTA", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> get_autoFillCCTA(HttpServletRequest request, HttpServletResponse response) {
        String num = request.getParameter("num");
        CCTA ccta = ccta_repository.findCCTABy编号(num);
        Map<String, Object> map = new HashMap<>();
        if (ccta == null) {
            map.put("exist", false);
        } else {
            map.put("exist", true);
            map.put("name", ccta.get姓名());
            map.put("gender", ccta.get性别());
        }
        return map;
    }


    @RequireAuth
    @GetMapping("/CCTASearch")
    public String get_CaseSearch(HttpSession session, Model model) {

        Utility.injectUser(session, model);
        model.addAttribute("type", "CCTA");

        return "CaseSearch";
    }


    @RequireAuth
    @GetMapping("/CCTASearch/{search}")
    public String get_CaseSearch_result(HttpSession session, Model model, @PathVariable("search") String search) {
        Utility.injectUser(session, model);

        List<CCTA> byIdAndName = ccta_repository.findBy编号ContainsOr姓名ContainsAllIgnoreCase(search, search);

        model.addAttribute("CCTAList", byIdAndName);
        return "CCTASearchResult";
    }


}