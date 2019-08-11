//package com.achd.mongo.Controller;
//
//import com.achd.mongo.Entity.BDT.BDT_Sub.BDTS;
//import com.achd.mongo.Entity.BaseEntity;
//import com.achd.mongo.Service.BaseEntity_Repository;
//import com.achd.mongo.Utilities.RequireAuth;
//import com.achd.mongo.Utilities.Utility;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.achd.mongo.Utilities.Utility.injectUser;
//
//@Controller
//public class BDTController {
//    @Autowired
//    BaseEntity_Repository baseEntity_repository;
//
//    @RequireAuth
//    @GetMapping("/BDTInsert")
//    public String get_BDTInsert(HttpSession session, Model model) {
//        injectUser(session, model);
//        return "BDTInsert";
//    }
//
//    @RequireAuth
//    @PostMapping("/BDTInsert")
//    public String post_BDTInsert(BaseEntity baseEntity, HttpSession session, Model model) {
//        BaseEntity hadBaseEntity = baseEntity_repository.findBaseEntitiyBy编号(baseEntity.get编号());
//        if (hadBaseEntity == null) {
//            baseEntity_repository.save(baseEntity);
//        } else {
//            ArrayList<BDTS> hadUserBDTs = hadBaseEntity.getBDTs();
//            if (hadUserBDTs == null) {
//                hadUserBDTs = new ArrayList<>();
//            }
//            hadUserBDTs.add(baseEntity.getBDTs().get(0));
//            hadBaseEntity.setBDTs(hadUserBDTs);
//            baseEntity_repository.save(hadBaseEntity);
//        }
//
//
//        injectUser(session, model);
//        return "BDTInsert";
//    }
//
//    @RequireAuth
//    @GetMapping("/BDTSearch")
//    public String get_BDTSearch(HttpSession session, Model model) {
//
//        Utility.injectUser(session, model);
//        model.addAttribute("type", "BDT");
//
//        return "CaseSearch";
//    }
//
//
//    @RequireAuth
//    @GetMapping("/BDTSearch/{search}")
//    public String get_BDTSearch_result(HttpSession session, Model model, @PathVariable("search") String search) {
//        Utility.injectUser(session, model);
//
//        List<BaseEntity> byId = baseEntity_repository.findBy编号ContainsOr姓名ContainsAllIgnoreCase(search, search);
//
//        model.addAttribute("BDTList", byId);
//        return "BDTSearchResult";
//    }
//
//}
