package com.achd.mongo.Service;

import com.achd.mongo.Entity.BaseEntity;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;

@Repository
public class Query_Repository {

    private MongoTemplate mongoTemplate;

    public Query_Repository() {
        mongoTemplate = new MongoTemplate(new MongoClient("101.132.120.236", 27017), "ACHD");
    }

    public static void main(String[] args) {
//        Object o = 1;
//        Query query = new Query(Criteria.where(String.format("BDTs.%s", "高血压病.有无")).is(o)
//                .and("CCTAs.冠状动脉CT是否异常").elemMatch(Criteria.where("检查时间").size(1)).is(true));
//
////        query = new BasicQuery("{\"CCTAs\":{$slice:[\"$CCTAs\", -1]}}");
//
////        query.fields().include("编号");/=
//
////        long l = new Query_Repository().count(query);
//        List<BaseEntity> baseEntities = new Query_Repository().mongoTemplate.find(query, BaseEntity.class);
////        System.out.println(l);
//        System.out.println(baseEntities);
        new Query_Repository().test();

    }

    public void test() {
//        Aggregation aggregation1 = Aggregation.newAggregation(Aggregation.group("CCTAs").max("检查时间").as("检查时间"));
//        AggregationResults<BaseEntity> outputTypeCount1 =
//                mongoTemplate.aggregate(aggregation1, "baseEntity", BaseEntity.class);
//
//        for (Iterator<BaseEntity> iterator = outputTypeCount1.iterator(); iterator.hasNext(); ) {
//            BaseEntity obj = iterator.next();
//            System.out.println(obj.getCCTAs());
//        }

        BasicDBObject bson = new BasicDBObject();
        bson.put("$eval","db.user.find({}, {'CCTAs':{$slice:['$CCTAs', -1]}}");
        Object object = mongoTemplate.getDb().runCommand(bson);
        System.out.println(object);
    }

    public List<BaseEntity> select(Query query) {
        return mongoTemplate.find(query, BaseEntity.class);
    }

    public long count(Query query) {
        return mongoTemplate.count(query, BaseEntity.class);
    }
}
