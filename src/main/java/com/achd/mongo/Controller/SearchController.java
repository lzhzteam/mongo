package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BDT.BDT;
import com.achd.mongo.Service.BDT_Repository;
import com.achd.mongo.Utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    BDT_Repository bdt_repository;

    @GetMapping("/CaseSearch")
    public String caseSearchGet(HttpSession session, Model model) {

        Utility.injectUser(session, model);

        return "CaseSearch";
    }

    @GetMapping("/CaseSearch/{search}")
    public String caseSearchResultGet(HttpSession session, Model model, @PathVariable("search") String search) {
        Utility.injectUser(session, model);

        List<BDT> byId = bdt_repository.findByNumContainsOrNameContainsAllIgnoreCase(search, search);

        model.addAttribute("BDTList", byId);
        return "CaseSearchResult";


    }


}
