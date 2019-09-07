package com.achd.mongo.Controller;

import com.achd.mongo.Entity.BaseEntity;
import com.achd.mongo.Entity.WebResponse;
import com.achd.mongo.Service.BaseEntity_Repository;
import com.achd.mongo.Utilities.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    BaseEntity_Repository baseEntity_repository;

    // 搜索BDT
    @PostMapping("")
    public WebResponse searchPatient(@RequestBody Map<String, Object> searchCondition) {
        System.out.println("搜索条件："+searchCondition);
        List<BaseEntity> byCondition = baseEntity_repository.findBy编号ContainsOr姓名ContainsIgnoreCase(
                searchCondition.get("searchCondition").toString(),
                searchCondition.get("searchCondition").toString()
        );

        return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.SUCCESS, byCondition);
    }


}
