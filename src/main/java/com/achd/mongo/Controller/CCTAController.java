package com.achd.mongo.Controller;

import com.achd.mongo.Entity.CCTA.CCTA;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTAs;
import com.achd.mongo.Service.CCTA_Repository;
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