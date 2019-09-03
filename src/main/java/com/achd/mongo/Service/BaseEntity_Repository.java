package com.achd.mongo.Service;

import com.achd.mongo.Entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BaseEntity_Repository extends MongoRepository<BaseEntity, String> {

    List<BaseEntity> findBy编号ContainsOr姓名ContainsIgnoreCase(String num, String name);


    BaseEntity findBaseEntitiyBy编号(String num);
}
