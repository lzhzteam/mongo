package com.achd.mongo.Service;

import com.achd.mongo.Entity.BDT.BDT;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class Test_Repository {


    private MongoTemplate mongoTemplate;


    public Test_Repository() {
        mongoTemplate = new MongoTemplate(new MongoClient("101.132.120.236", 27017), "ACHD");
    }

    public static void main(String[] args) {
        Query query = new Query(Criteria.where("BDTs").elemMatch(
                Criteria.where("检查目的.非胸痛症状").is(false)
        ));

        long l = new Test_Repository().countBDT(query);
        System.out.println(l);

    }

    public long countBDT(Query query) {
        return mongoTemplate.count(query, BDT.class);
    }
}
