package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BDT.BDT;
import com.achd.mongo.Service.BDT_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
public class GetController {

    @Autowired
    private BDT_Repository BDTRepository;


    @RequestMapping(value = "/BDT")
    public List<BDT> getAllBDT() {
        return BDTRepository.findAll();
    }

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/BDTInsert")
    public String getBDTInsert(){
        return "bdtinsert";
    }

    @GetMapping("/CCTAInsert")
    public String getCCTAInsert(){
        return "cctainsert";
    }

}
