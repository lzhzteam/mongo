package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BaseEntity;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTAS;
import com.achd.mongo.Service.BaseEntity_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/CCTA")
public class CCTAController {

    @Autowired
    BaseEntity_Repository baseEntity_repository;

//    @RequireAuth
//    @GetMapping("/CCTAInsert")
//    public String get_CCTAInsert(HttpSession session, Model model) {
//        injectUser(session, model);
//        return "CCTAInsert";
//    }
//
//    @RequireAuth
//    @PostMapping("/CCTAInsert")
//    public String post_CCTAInsert(BaseEntity baseEntity, HttpSession session, Model model) {
//        BaseEntity hadBaseEntity = baseEntity_repository.findBaseEntitiyBy编号(baseEntity.get编号());
//        if (hadBaseEntity == null) {
//            baseEntity_repository.save(baseEntity);
//        } else {
//            List<CCTAS> hadUserCCTAS = hadBaseEntity.getCCTAs();
//            hadUserCCTAS.add(baseEntity.getCCTAs().get(0));
//            baseEntity_repository.save(hadBaseEntity);
//        }
//
//        injectUser(session, model);
//        return "CCTAInsert";
//    }
//
//    @RequireAuth
//    @GetMapping("/CCTASearch")
//    public String get_CCTASearch(HttpSession session, Model model) {
//
//        Utility.injectUser(session, model);
//        model.addAttribute("type", "CCTA");
//
//        return "CaseSearch";
//    }
//
//
//    @RequireAuth
//    @GetMapping("/CCTASearch/{search}")
//    public String get_CCTASearch_result(HttpSession session, Model model, @PathVariable("search") String search) {
//        Utility.injectUser(session, model);
//
//        List<BaseEntity> byIdAndName = baseEntity_repository.findBy编号ContainsOr姓名ContainsAllIgnoreCase(search, search);
//
//        model.addAttribute("CCTAList", byIdAndName);
//        return "CCTASearchResult";
//    }

    @PostMapping(value = "")
    public Boolean insertCCTA(@RequestBody BaseEntity baseEntity) {
        try {
            BaseEntity hadBaseEntity = baseEntity_repository.findBaseEntitiyBy编号(baseEntity.get编号());
            if (hadBaseEntity == null) {
                baseEntity_repository.save(baseEntity);
            } else {
                List<CCTAS> hadUserCCTAS = hadBaseEntity.getCCTAs();
                hadUserCCTAS.add(baseEntity.getCCTAs().get(0));
                baseEntity_repository.save(hadBaseEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}