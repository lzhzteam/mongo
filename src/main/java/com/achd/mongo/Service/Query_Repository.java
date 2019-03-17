package com.achd.mongo.Service;

import com.achd.mongo.Entity.BDT.BDT;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Query_Repository {

    private MongoTemplate mongoTemplate;

    public Query_Repository() {
        mongoTemplate = new MongoTemplate(new MongoClient("101.132.120.236", 27017), "ACHD");
    }

    public static void main(String[] args) {
        Query query = new Query(Criteria.where("BDTs").elemMatch(
                Criteria.where("检查目的.非胸痛症状").is(false)
        ));

        query.fields().include("编号");

        long l = new Query_Repository().countBDT(query);
        List<BDT> bdts = new Query_Repository().mongoTemplate.find(query, BDT.class);
        System.out.println(l);
        System.out.println(bdts);

    }

    public List<BDT> getNum(String name, Object value) {
        Query query = new Query(Criteria.where("BDTs").elemMatch(
                Criteria.where(name).is(value)
        ));
        query.fields().include("编号");
        List<BDT> bdts = new Query_Repository().mongoTemplate.find(query, BDT.class);

        return bdts;
    }

    public long countBDT(Query query) {
        return mongoTemplate.count(query, BDT.class);
    }
}
