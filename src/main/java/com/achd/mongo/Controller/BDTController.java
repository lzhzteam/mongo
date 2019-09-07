//package com.achd.mongo.Controller;
//
//import com.achd.mongo.Entity.BaseEntity;
//import com.achd.mongo.Entity.WebResponse;
//import com.achd.mongo.Service.BaseEntity_Repository;
//import com.achd.mongo.Utilities.ResponseUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/BDT")
//public class BDTController {
//    @Autowired
//    BaseEntity_Repository baseEntity_repository;
//
//    @PostMapping()
//    public WebResponse insertBdt(@RequestBody BaseEntity bdt) {
//        try {
//            BaseEntity baseEntity = baseEntity_repository.findBaseEntitiyBy编号(bdt.get编号());
//            if (baseEntity == null) {
//                baseEntity_repository.save(bdt);
//                return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.SUCCESS);
//            }
//
//            if (!baseEntity.get姓名().equals(bdt.get姓名())) {
//
//            }
//        }
//    }
//
////    @RequireAuth
////    @GetMapping("/BDTInsert")
////    public String get_BDTInsert(HttpSession session, Model model) {
////        injectUser(session, model);
////        return "BDTInsert";
////    }
////
////    @RequireAuth
////    @PostMapping("/BDTInsert")
////    public String post_BDTInsert(BaseEntity baseEntity, HttpSession session, Model model) {
////        BaseEntity hadBaseEntity = baseEntity_repository.findBaseEntitiyBy编号(baseEntity.get编号());
////        if (hadBaseEntity == null) {
////            baseEntity_repository.save(baseEntity);
////        } else {
////            ArrayList<BDTS> hadUserBDTs = hadBaseEntity.getBDTs();
////            if (hadUserBDTs == null) {
////                hadUserBDTs = new ArrayList<>();
////            }
////            hadUserBDTs.add(baseEntity.getBDTs().get(0));
////            hadBaseEntity.setBDTs(hadUserBDTs);
////            baseEntity_repository.save(hadBaseEntity);
////        }
////
////
////        injectUser(session, model);
////        return "BDTInsert";
////    }
////
////    @RequireAuth
////    @GetMapping("/BDTSearch")
////    public String get_BDTSearch(HttpSession session, Model model) {
////
////        Utility.injectUser(session, model);
////        model.addAttribute("type", "BDT");
////
////        return "CaseSearch";
////    }
////
////
////    @RequireAuth
////    @GetMapping("/BDTSearch/{search}")
////    public String get_BDTSearch_result(HttpSession session, Model model, @PathVariable("search") String search) {
////        Utility.injectUser(session, model);
////
////        List<BaseEntity> byId = baseEntity_repository.findBy编号ContainsOr姓名ContainsAllIgnoreCase(search, search);
////
////        model.addAttribute("BDTList", byId);
////        return "BDTSearchResult";
////    }
//
//}
