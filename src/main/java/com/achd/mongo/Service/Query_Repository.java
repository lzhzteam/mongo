package com.achd.mongo.Service;

import com.achd.mongo.Entity.BaseEntity;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Query_Repository {

    private MongoTemplate mongoTemplate;

    public Query_Repository() {
        mongoTemplate = new MongoTemplate(new MongoClient("101.132.120.236", 27017), "ACHD");
    }

//    public static void main(String[] args) {
//        Query query = new Query(Criteria.where("BDTs").elemMatch(
//                Criteria.where("检查目的.非胸痛症状").is(false)
//        ));
//
//        query.fields().include("编号");
//
//        long l = new Query_Repository().countBDT(query);
//        List<BaseEntity> baseEntities = new Query_Repository().mongoTemplate.find(query, BaseEntity.class);
//        System.out.println(l);
//        System.out.println(baseEntities);
//
//    }

    public List<BaseEntity> get(Query query) {
        return mongoTemplate.find(query, BaseEntity.class);
    }

    public long count(Query query) {
        return mongoTemplate.count(query, BaseEntity.class);
    }
}
