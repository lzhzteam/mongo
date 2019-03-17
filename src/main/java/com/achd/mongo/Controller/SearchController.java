package com.achd.mongo.Controller;

import com.achd.mongo.Service.BDT_Repository;
import com.achd.mongo.Service.CCTA_Repository;
import com.achd.mongo.Utilities.RequireAuth;
import com.achd.mongo.Utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.achd.mongo.Utilities.Utility.injectUser;

@Controller
public class SearchController {

    @Autowired
    CCTA_Repository ccta_repository;

    @Autowired
    BDT_Repository bdt_repository;

    @RequireAuth
    @GetMapping("/PathogenySearch")
    public String get_PathogenySearch(HttpSession session, Model model) {
        injectUser(session, model);
        return "PathogenySearch";
    }

//    @RequireAuth
//    @GetMapping("/PathogenySearchResult")
//    public String getPathogenySearchResult(HttpSession session, Model model) {
//        injectUser(session, model);
//        return "PathogenySearchResult";
//    }

    @RequestMapping(value = "/PathogenySearchResult", method = RequestMethod.POST)
    public String get_PathogenySearchResult(HttpServletRequest request, HttpSession session, Model model) {
        Utility.injectUser(session, model);
        System.out.println(request.getParameter("search1"));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        model.addAttribute("aaaaa", list);

        return "PathogenySearchResult";
    }

//    @RequireAuth
//    @GetMapping("/CCTASearch")
//    public String getCCTASearch(HttpSession session, Model model) {
//        injectUser(session, model);
//        return "cctasearch";
//    }

    /*@RequestMapping(value = "/PathogenySearch", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> autoFillBDT(HttpServletRequest request, HttpServletResponse response) {

        return map;
    }*/
}
