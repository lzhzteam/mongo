package com.achd.mongo.Controller;

import com.achd.mongo.Entity.CCTA.CCTA;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTAs;
import com.achd.mongo.Service.CCTA_Repository;
import com.achd.mongo.Utilities.RequireAuth;
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
public class CCTAController {

    @Autowired
    CCTA_Repository ccta_repository;

    @RequireAuth
    @GetMapping("/CCTAInsert")
    public String getCCTAInsert(HttpSession session, Model model) {
        injectUser(session, model);
        return "cctainsert";
    }

    @RequireAuth
    @PostMapping("/CCTAInsert")
    @ResponseBody
    public CCTA CCTAInsertPost(CCTA ccta, HttpSession session, Model model) {
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

    @RequestMapping(value = "/autoFillCCTA", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> autoFillCCTA(HttpServletRequest request, HttpServletResponse response) {
        String num = request.getParameter("num");
        CCTA ccta = ccta_repository.findCCTABy编号(num);
        Map<String, Object> map = new HashMap<>();
        if (ccta == null) {
            map.put("exist", false);
        } else {
            map.put("exist", true);
            map.put("name", ccta.get姓名());
            map.put("gender", ccta.get性别());
        }
        return map;
    }
}