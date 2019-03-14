package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BDT.BDT;
import com.achd.mongo.Entity.BDT.BDT_Sub.BDTS;
import com.achd.mongo.Service.BDT_Repository;
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
public class InsertController {

    @Autowired
    BDT_Repository bdt_repository;

    @GetMapping("/BDTInsert")
    public String getBDTInsert(HttpSession session, Model model) {
        injectUser(session, model);
        return "bdtinsert";
    }

    @GetMapping("/CCTAInsert")
    public String getCCTAInsert(HttpSession session, Model model) {

        injectUser(session, model);
        return "cctainsert";
    }


    @PostMapping("/BDTInsert")
    @ResponseBody
    public BDT BDTInsertPost(BDT bdt, HttpSession session, Model model) {
        BDT hadUser = bdt_repository.findBDTBy编号(bdt.get编号());
        if (hadUser == null) {
            bdt_repository.save(bdt);
        } else {
            List<BDTS> hadUserBDTs = hadUser.getBDTs();
            hadUserBDTs.add(bdt.getBDTs().get(0));
            bdt_repository.save(hadUser);
        }
        return bdt;
    }

    @RequestMapping(value = "/autoFill", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> autoFill(HttpServletRequest request, HttpServletResponse response) {
        String num = request.getParameter("num");
        BDT bdt = bdt_repository.findBDTBy编号(num);
        Map<String, Object> map = new HashMap<>();
        if (bdt == null) {
            map.put("exist", false);
        } else {
            map.put("exist", true);
            map.put("name", bdt.get姓名());
            map.put("gender", bdt.get性别());
        }
        return map;
    }
}