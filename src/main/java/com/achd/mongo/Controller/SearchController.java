package com.achd.mongo.Controller;

import com.achd.mongo.Utilities.Utility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class SearchController {


    @GetMapping("/CaseSearch")
    public String caseSearchGet(HttpSession session, Model model) {

        Utility.injectUser(session, model);

        return "CaseSearch";
    }

    @GetMapping("/CaseSearch/{search}")
    public String caseSearchResultGet(HttpSession session, Model model, @PathVariable("search") String search) {
        Utility.injectUser(session, model);


        return "CaseSearchResult";
    }

}
