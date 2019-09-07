package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BaseEntity;
import com.achd.mongo.Entity.WebResponse;
import com.achd.mongo.Service.DataService;
import com.achd.mongo.Utilities.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/BDT")
    public WebResponse insertBDT(@RequestBody BaseEntity bdt) {
        return dataService.insert(bdt);
    }

    @PostMapping("/CCTA")
    public WebResponse insertCCTA(@RequestBody BaseEntity ccta) {
        return dataService.insert(ccta);
    }

    @GetMapping("/search/{searchCondition}")
    public WebResponse searchPatient(@PathVariable("searchCondition") String searchCondition) {
        return dataService.search(searchCondition);
    }
}