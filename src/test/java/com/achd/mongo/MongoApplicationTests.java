package com.achd.mongo;

import com.achd.mongo.Entity.BDT.BDT_Sub.BDT;
import com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub.Exercise;
import com.achd.mongo.Entity.BaseEntity;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTA;
import com.achd.mongo.Service.DataService;
import com.achd.mongo.Utilities.SomeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoApplicationTests {
    @Autowired
    DataService dataService;

    @Test
    public void contextLoads() {
        if (false) {
            return;
        }


        SomeUtil someUtil = new SomeUtil();

        for (int num = 0; num < 1000; num++) {
            BaseEntity baseEntity = someUtil.randomPerson(num);
//            System.out.println(baseEntity);
            dataService.insert(baseEntity);
        }
    }

}
