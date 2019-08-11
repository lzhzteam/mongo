//package com.achd.mongo.Controller;
//
//import com.achd.mongo.Entity.BaseEntity;
//import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTAS;
//import com.achd.mongo.Service.BaseEntity_Repository;
//import com.achd.mongo.Service.Query_Repository;
//import com.achd.mongo.Utilities.RequireAuth;
//import com.achd.mongo.Utilities.Utility;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static com.achd.mongo.Utilities.Utility.injectUser;
//
//@Controller
//public class SearchController {
//
//    @Autowired
//    BaseEntity_Repository baseEntity_repository;
//
//
//    @RequestMapping(value = "/autoFill", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> get_autoFillBDT(HttpServletRequest request, HttpServletResponse response) {
//        String num = request.getParameter("num");
//        BaseEntity baseEntity = baseEntity_repository.findBaseEntitiyBy编号(num);
//        Map<String, Object> map = new HashMap<>();
//        if (baseEntity == null) {
//            map.put("exist", false);
//        } else {
//            map.put("exist", true);
//            map.put("name", baseEntity.get姓名());
//            map.put("gender", baseEntity.get性别());
//        }
//        return map;
//    }
//
//    @RequireAuth
//    @GetMapping("/PathogenySearch")
//    public String get_PathogenySearch(HttpSession session, Model model) {
//        injectUser(session, model);
//        return "PathogenySearch";
//    }
//
////    @RequireAuth
////    @GetMapping("/PathogenySearchResult")
////    public String getPathogenySearchResult(HttpSession session, Model model) {
////        injectUser(session, model);
////        return "PathogenySearchResult";
////    }
//
//    @RequestMapping(value = "/PathogenySearchResult", method = RequestMethod.POST)
//    public String get_PathogenySearchResult(HttpServletRequest request, HttpSession session, Model model) {
//        Utility.injectUser(session, model);
//        String search1 = request.getParameter("search1");
//        String search2 = request.getParameter("search2");
//
//        Query_Repository query_repository = new Query_Repository();
//
//        String name = null;
//        Object value = null;
//
//        switch (search1) {
//            case "检查目的":
//            case "其他疾病史":
//                name = search1 + "." + search2;
//                value = true;
//                break;
//            case "高血压病":
//            case "血脂异常":
//            case "脑卒中病史":
//            case "外周血管病":
//            case "心肌梗死":
//                name = search1 + ".有无";
//                value = 3;
//                break;
//            case "糖尿病史":
//                name = search1 + ".分型";
//                value = search2;
//                break;
//            case "吸烟史":
//            case "饮酒史":
//            case "体育锻炼史":
//                name = search1 + ".频率";
//                switch (search2) {
//                    case "经常吸":
//                    case "经常饮":
//                    case "基本不锻炼":
//                        value = 1;
//                        break;
//                    case "偶吸":
//                    case "偶饮":
//                    case "每周小于3次":
//                        value = 2;
//                        break;
//                    case "过去吸，现已戒烟":
//                    case "过去饮":
//                    case "每周大于等于3次":
//                        value = 3;
//                        break;
//                    case "从不吸":
//                    case "从不饮":
//                        value = 4;
//                        break;
//                }
//                break;
//            case "家族史":
//                switch (search2) {
//                    case "冠心病家族史":
//                        name = search1 + "." + search2 + "." + "有无";
//                        break;
//                    case "高脂血症家族史":
//                        name = search1 + "." + search2;
//                        break;
//                }
//                value = 1;
//                break;
//        }
//
//        // query1 病因+冠心病
//        Query query1 = new Query();
//        query1.addCriteria(Criteria.where("BDTs").elemMatch(
//                Criteria.where(name).is(value)
//        ));
//        query1.addCriteria(Criteria.where("CCTAs").elemMatch(
//                Criteria.where("冠状动脉CT是否异常").is(true)
//        ));
//        List<BaseEntity> baseEntities = query_repository.get(query1);
//        long num1 = baseEntities.size();
//        long[] location = new long[18];
//        long[] locationScore = new long[18];
//        long[] length = new long[3];
//        long[] lengthScore = new long[3];
//        long[] feature = new long[3];
//        long[] featureScore = new long[3];
//        for (int i = 0; i < num1; i++) {
//            List<CCTAS> cctas = baseEntities.get(i).getCCTAs();
//            CCTAS ccta = cctas.get(cctas.size() - 1);
//            location[ccta.get病变位置() - 1]++;
//            length[ccta.get病变长度() - 1]++;
//            feature[ccta.get斑块特征() - 1]++;
//        }
//
//        // 测试
//        for (int i = 0; i < 18; i++)
//            location[i] = (long) (Math.random() * 1000);
//        for (int i = 0; i < 3; i++) {
//            length[i] = (long) (Math.random() * 1000);
//            feature[i] = (long) (Math.random() * 1000);
//        }
//
//        for (int i = 0; i < 18; i++)
//            locationScore[i] = location[i] / num1;
//        for (int i = 0; i < 3; i++) {
//            lengthScore[i] = length[i] / num1;
//            featureScore[i] = feature[i] / num1;
//        }
//
//        // query2 病因+非冠心病
//        Query query2 = new Query();
//        query2.addCriteria(Criteria.where("BDTs").elemMatch(
//                Criteria.where(name).is(value)
//        ));
//        query2.addCriteria(Criteria.where("CCTAs").elemMatch(
//                Criteria.where("冠状动脉CT是否异常").is(false)
//        ));
//        long num2 = query_repository.count(query2);
//
//        // query3 冠心病
//        Query query3 = new Query();
//        query3.addCriteria(Criteria.where("CCTAs").elemMatch(
//                Criteria.where("冠状动脉CT是否异常").is(true)
//        ));
//
//        // 非病因+冠心病
//        long num3 = query_repository.count(query3) - num1;
//
//        // 非病因+非冠心病
//        long num4 = baseEntity_repository.count() - num1 - num2 - num3;
//
//        model.addAttribute("search1", search1);
//        model.addAttribute("search2", search2);
//        model.addAttribute("num1", num1);
//        model.addAttribute("num2", num2);
//        model.addAttribute("num3", num3);
//        model.addAttribute("num4", num4);
//        model.addAttribute("location", location);
//        model.addAttribute("locationScore", locationScore);
//        model.addAttribute("length", length);
//        model.addAttribute("lengthScore", lengthScore);
//        model.addAttribute("feature", feature);
//        model.addAttribute("featureScore", featureScore);
//
//        return "PathogenySearchResult";
//    }
//
////    @RequireAuth
////    @GetMapping("/CCTASearch")
////    public String getCCTASearch(HttpSession session, Model model) {
////        injectUser(session, model);
////        return "cctasearch";
////    }
//
//    /*@RequestMapping(value = "/PathogenySearch", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> autoFillBDT(HttpServletRequest request, HttpServletResponse response) {
//
//        return map;
//    }*/
//}
