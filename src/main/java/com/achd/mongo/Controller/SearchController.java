package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BDT.BDT;
import com.achd.mongo.Entity.CCTA.CCTA;
import com.achd.mongo.Service.BDT_Repository;
import com.achd.mongo.Service.CCTA_Repository;
import com.achd.mongo.Service.Query_Repository;
import com.achd.mongo.Utilities.RequireAuth;
import com.achd.mongo.Utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.achd.mongo.Utilities.Utility.injectUser;

@Controller
public class SearchController {

    @Autowired
    CCTA_Repository ccta_repository;

    @Autowired
    BDT_Repository bdt_repository;

    @RequestMapping(value = "/autoFill", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> get_autoFillBDT(HttpServletRequest request, HttpServletResponse response) {
        String num = request.getParameter("num");
        BDT bdt = bdt_repository.findBDTBy编号(num);
        CCTA ccta = ccta_repository.findCCTABy编号(num);
        Map<String, Object> map = new HashMap<>();
        if (bdt == null && ccta == null) {
            map.put("exist", false);
        } else if (ccta == null) {
            map.put("exist", true);
            map.put("name", bdt.get姓名());
            map.put("gender", bdt.get性别());
        } else {
            map.put("exist", true);
            map.put("name", ccta.get姓名());
            map.put("gender", ccta.get性别());
        }
        return map;
    }

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
        String search1 = request.getParameter("search1");
        String search2 = request.getParameter("search2");

        List<BDT> bdts = new ArrayList<>();

        Query_Repository query_repository = new Query_Repository();

        String name = null;
        Object value = null;

        switch (search1) {
            case "检查目的":
            case "其他疾病史":
                name = search1 + "." + search2;
                value = true;
                break;
            case "高血压病":
            case "血脂异常":
            case "脑卒中病史":
            case "外周血管病":
            case "心肌梗死":
                name = search1 + ".有无";
                value = 3;
                break;
            case "糖尿病史":
                name = search1 + ".分型";
                value = search2;
                break;
            case "吸烟史":
            case "饮酒史":
            case "体育锻炼史":
                name = search1 + ".频率";
                switch (search2) {
                    case "经常吸":
                    case "经常饮":
                    case "基本不锻炼":
                        value = 1;
                        break;
                    case "偶吸":
                    case "偶饮":
                    case "每周小于3次":
                        value = 2;
                        break;
                    case "过去吸，现已戒烟":
                    case "过去饮":
                    case "每周大于等于3次":
                        value = 3;
                        break;
                    case "从不吸":
                    case "从不饮":
                        value = 4;
                        break;
                }
                break;
            case "家族史":
                switch (search2) {
                    case "冠心病家族史":
                        name = search1 + "." + search2 + "." + "有无";
                        break;
                    case "高脂血症家族史":
                        name = search1 + "." + search2;
                        break;
                }
                value = 1;
                break;
        }

        bdts = query_repository.getNum(name, value);

        List<String> nums = new ArrayList<>();
        for (int i = 0; i < bdts.size(); i++) {
            nums.add(bdts.get(i).get编号());
        }

//        System.out.println(ccta_repository.countCCTABy编号InAAndCCTAs冠状动脉是否异常(
//                nums,true
//        ));

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
