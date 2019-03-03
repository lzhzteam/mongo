package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BDT;
import com.achd.mongo.Service.BDT_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class GetController {

    @Autowired
    private BDT_Repository BDTRepository;


    @RequestMapping(value = "/BDT")
    public List<BDT> getAllBDT() {


        return BDTRepository.findAll();
    }




}
