package com.achd.mongo.Service;

import com.achd.mongo.Entity.BaseEntityCurrent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseEntityCurrent_Repository extends MongoRepository<BaseEntityCurrent, String> {

    BaseEntityCurrent findBy编号(String num);
}
