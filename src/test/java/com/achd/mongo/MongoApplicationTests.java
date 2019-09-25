package com.achd.mongo;

import com.achd.mongo.Entity.BaseEntity;
import com.achd.mongo.Service.DataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MongoApplicationTests {
    @Autowired
    DataService dataService;

    @Test
    public void contextLoads() {
        if (true) {
            return;
        }

        for (int num = 0; num < 1000; num++) {
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setId(String.valueOf(num));
            baseEntity.set姓名(String.valueOf(num));
            baseEntity.set性别(num % 2 == 0 ? "男" : "女");

        }
    }

}
